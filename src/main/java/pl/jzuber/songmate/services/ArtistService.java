package pl.jzuber.songmate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.model.SongmateArtist;
import pl.jzuber.songmate.persistence_layer.repositories.ArtistRepository;

@Service
public class ArtistService {

    final ArtistRepository artistRepository;

    @Autowired //DI
    public ArtistService(/*@Qualifier("fakeArtistRepository") */ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable<SongmateArtist> getArtists(){
//        System.out.println(artistRepository.findAll());
        return artistRepository.findAll();
    }


    //@Override
    public SongmateArtist save(SongmateArtist songmateArtist) {
        return artistRepository.save(songmateArtist);
    }

    //@Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }



}
