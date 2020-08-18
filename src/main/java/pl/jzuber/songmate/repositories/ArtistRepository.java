package pl.jzuber.songmate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.Artist;

@Repository("test")
public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
