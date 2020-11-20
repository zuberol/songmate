package pl.jzuber.songmate.persistance_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
