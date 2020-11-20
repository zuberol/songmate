package pl.jzuber.songmate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.persistance_layer.repositories.ArtistRepository;

@Service
public class ArtistService {

    final ArtistRepository artistRepository;

    @Autowired //DI
    public ArtistService(/*@Qualifier("fakeArtistRepository") */ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable<Artist> getArtists(){
        System.out.println(artistRepository.findAll());
        return artistRepository.findAll();
    }


    //@Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    //@Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }



}
