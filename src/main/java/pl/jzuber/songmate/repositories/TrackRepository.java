package pl.jzuber.songmate.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import pl.jzuber.songmate.model.Track;

public interface TrackRepository extends R2dbcRepository<Track, Long> {
}
