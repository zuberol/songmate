package pl.jzuber.songmate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.dao.DataAccessObject;
import pl.jzuber.songmate.model.Artist;
import reactor.core.publisher.Flux;


//TODO refactor it to reactive

@RestController             // sends JSON data
@RequestMapping("/app")
//@PreAuthorize("hasRole('ROLE_ADMIN')")  //has_authority
//@PreAuthorize("hasRole('ROLE_STUDENT')")  //has_authority
public class ArtistController {

    private final DataAccessObject dataAccessObject;

    public ArtistController(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    //    final ArtistService artistService;
//    public ArtistController(ArtistService artistService) {
//        this.artistService = artistService;
//    }
//
    @GetMapping("/artists")
    Iterable<Artist> getArtists(){
        return dataAccessObject.artistRepository.findAll().toIterable();
    }

    @GetMapping("/top")
    Flux<Artist> getTopArtists(){
        return
        dataAccessObject.artistRepository.findTopArtists("DDB");
    }

}
