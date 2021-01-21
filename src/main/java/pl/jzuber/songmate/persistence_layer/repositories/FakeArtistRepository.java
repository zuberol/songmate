package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.Artist;

import java.util.Optional;

@Repository//("fakeArtistRepository")
@Profile("dev")
public class FakeArtistRepository implements ArtistRepository {
    @Override
    public <S extends Artist> S save(S s) {
        return null;
    }

    @Override
    public <S extends Artist> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Artist> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Artist> findAll() {
        return null;
    }

    @Override
    public Iterable<Artist> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Artist artist) {

    }

    @Override
    public void deleteAll(Iterable<? extends Artist> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
