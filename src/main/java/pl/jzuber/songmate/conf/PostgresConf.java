package pl.jzuber.songmate.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "pl.jzuber.songmate.persistence_layer")
public class PostgresConf implements WebMvcConfigurer {

    private final DataSource dataSource;

    @Autowired
    @Lazy       // so injecting DataSource from this file can be possible
    public PostgresConf(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        return dataSourceBuilder.driverClassName("org.postgresql.Driver")
                         .url("jdbc:postgresql://localhost:5432/kuba")    //https://jdbc.postgresql.org/documentation/81/connect.html
                         .username("kuba")
                         .password("kuba")
                         .build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource);
    }

    @Bean
    public JdbcDaoImpl userDetailsService() {
        JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
        jdbcDaoImpl.setDataSource(dataSource);

        return jdbcDaoImpl;
    }


    @Override   //todo delete that, learn CORS
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }

}
