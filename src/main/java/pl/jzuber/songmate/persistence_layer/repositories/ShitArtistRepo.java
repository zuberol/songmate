package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.SongmateArtist;

import java.util.Optional;

@Repository
@Profile("prod")
public class ShitArtistRepo implements ArtistRepository {
    @Override
    public <S extends SongmateArtist> S save(S s) {
        return null;
    }

    @Override
    public <S extends SongmateArtist> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SongmateArtist> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<SongmateArtist> findAll() {
        return null;
    }

    @Override
    public Iterable<SongmateArtist> findAllById(Iterable<Long> iterable) {
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
    public void delete(SongmateArtist songmateArtist) {

    }

    @Override
    public void deleteAll(Iterable<? extends SongmateArtist> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
