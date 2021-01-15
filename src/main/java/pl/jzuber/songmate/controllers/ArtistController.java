package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;


@RestController
public class ArtistController {
    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/app/artists")
    public Iterable<Artist> getArtists(){
        return artistService.getArtists();
    }

}
