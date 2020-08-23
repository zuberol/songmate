package pl.jzuber.songmate.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;


@RestController             // sends JSON data
//@RequestMapping("/app")
//@PreAuthorize("hasRole('ROLE_ADMIN')")  //has_authority
@PreAuthorize("hasRole('ROLE_STUDENT')")  //has_authority
public class ArtistController {

    final ArtistService artistService;
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/app/artists")
    public Iterable<Artist> getArtists(){
        return artistService.getArtists();
    }

}
