package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;


@RestController             // sends JSON data
//@RequestMapping("/app")
//@PreAuthorize("hasRole('ROLE_ADMIN')")  //has_authority
//@PreAuthorize("hasRole('ROLE_STUDENT')")  //has_authority
public class ArtistController {

    private Environment environment;

    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
        System.out.println("co");

    }

    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService, Environment environment) {
        this.artistService = artistService;
        this.environment = environment;
    }

    @GetMapping("/app/artists")
    public Iterable<Artist> getArtists(){
        getActiveProfiles();
        return artistService.getArtists();
    }

}
