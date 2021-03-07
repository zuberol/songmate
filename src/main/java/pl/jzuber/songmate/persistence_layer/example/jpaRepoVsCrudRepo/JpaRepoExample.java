package pl.jzuber.songmate.persistence_layer.example.jpaRepoVsCrudRepo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.jzuber.songmate.model.SongmateUser;

import java.util.List;
import java.util.Optional;

public class JpaRepoExample implements JpaRepository<SongmateUser, Long> {

    @Override
    public List<SongmateUser> findAll() {
        return null;
    }

    @Override
    public List<SongmateUser> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SongmateUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<SongmateUser> findAllById(Iterable<Long> iterable) {
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

    @Override
    public <S extends SongmateUser> S save(S s) {
        return null;
    }

    @Override
    public <S extends SongmateUser> List<S> saveAll(Iterable<S> iterable) {
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
    public void flush() {

    }

    @Override
    public <S extends SongmateUser> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<SongmateUser> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public SongmateUser getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends SongmateUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SongmateUser> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SongmateUser> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SongmateUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SongmateUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SongmateUser> boolean exists(Example<S> example) {
        return false;
    }
}
