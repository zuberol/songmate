package pl.jzuber.songmate.persistence_layer.example.jpaRepoVsCrudRepo;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.model.SongmateUser;

import java.util.Optional;

public class CrudRepoExample implements CrudRepository<SongmateUser, Long> {
    @Override
    public <S extends SongmateUser> S save(S s) {
        return null;
    }

    @Override
    public <S extends SongmateUser> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SongmateUser> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<SongmateUser> findAll() {
        return null;
    }

    @Override
    public Iterable<SongmateUser> findAllById(Iterable<Long> iterable) {
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
    public void delete(SongmateUser songmateUser) {

    }

    @Override
    public void deleteAll(Iterable<? extends SongmateUser> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
