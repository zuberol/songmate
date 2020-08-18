package pl.jzuber.songmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SongmateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongmateApplication.class, args);
    }

}
