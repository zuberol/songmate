package pl.jzuber.songmate.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@Configuration
public class PostgresConf {

    private final DataSource dataSource;

    @Autowired
    @Lazy       // so injecting DataSource from this file can be possible
    public PostgresConf(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/kuba");     //https://jdbc.postgresql.org/documentation/81/connect.html
        dataSourceBuilder.username("kuba");
        dataSourceBuilder.password("kuba");

        //.addScript("classpath:org/springframework/security/core/userdetails/jdbc/users.ddl")
        //System.out.println(dataSourceBuilder.getClass().getName());

        return dataSourceBuilder.build();
    }

    //@Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource);

    }

    @Bean
    public JdbcDaoImpl userDetailsService() {
        JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
        jdbcDaoImpl.setDataSource(dataSource);

        return jdbcDaoImpl;
    }

}
