package pl.jzuber.songmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongmateApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SongmateApplication.class);
        application.setAdditionalProfiles("dev");
        application.run(args);
    }

}
