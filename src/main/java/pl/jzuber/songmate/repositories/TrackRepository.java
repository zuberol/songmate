package pl.jzuber.songmate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.Track;

@Repository("test")
public interface TrackRepository extends CrudRepository<Track, Long> {
}
