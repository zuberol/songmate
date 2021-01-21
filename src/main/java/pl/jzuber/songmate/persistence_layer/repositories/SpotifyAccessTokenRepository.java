package pl.jzuber.songmate.persistence_layer.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.SpotifyAccessToken;

@Repository
public interface SpotifyAccessTokenRepository extends CrudRepository<SpotifyAccessToken, Long> {
}
