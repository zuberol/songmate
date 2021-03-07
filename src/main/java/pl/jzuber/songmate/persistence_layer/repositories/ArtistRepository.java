package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.model.SongmateArtist;

public interface ArtistRepository extends CrudRepository<SongmateArtist, Long> {
}
