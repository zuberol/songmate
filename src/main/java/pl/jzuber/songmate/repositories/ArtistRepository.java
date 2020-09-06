package pl.jzuber.songmate.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.Artist;
import reactor.core.publisher.Flux;

@Repository
public interface ArtistRepository extends R2dbcRepository<Artist, Long> {

    //todo zmienic to
    //https://docs.spring.io/spring-data/r2dbc/docs/1.1.1.RELEASE/reference/html/#repositories.query-methods.details
    @Query("SELECT * FROM artist WHERE name = :name")
    Flux<Artist> findTopArtists(String name);

}
