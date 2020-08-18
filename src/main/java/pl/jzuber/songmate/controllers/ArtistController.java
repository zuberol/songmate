package pl.jzuber.songmate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;


@RestController             // sends JSON data
public class ArtistController {

    final ArtistService artistService;
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public Iterable<Artist> getArtists(){
        return artistService.getArtists();
    }

}
