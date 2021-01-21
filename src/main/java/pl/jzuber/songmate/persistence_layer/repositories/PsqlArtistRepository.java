package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public interface PsqlArtistRepository extends ArtistRepository {
}
