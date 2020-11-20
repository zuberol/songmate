package pl.jzuber.songmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaAuditing
@SpringBootApplication(exclude = {
        ErrorMvcAutoConfiguration.class
//        ,
//
//        /* wylaczanie spring-data */
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class
})
//@EnableJpaRepositories
public class SongmateApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SongmateApplication.class, args);
        SpringApplication application =
                new SpringApplication(SongmateApplication.class);
        application.setAdditionalProfiles("dev");
        application.run(args);
    }

}
