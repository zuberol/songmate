package pl.jzuber.songmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


//@EnableJpaAuditing      //todo co to robi, potrzebne to? chyba nie potrzebne na razie
@SpringBootApplication
@EnableR2dbcRepositories
public class SongmateApplication {

    static {
        // BlockHound.install();
    }

    public static void main(String[] args) {
        SpringApplication.run(SongmateApplication.class, args);

        // testing
        //ReactiveClient cliento = new ReactiveClient();
        //System.out.println(cliento.getResult());


    }

}
