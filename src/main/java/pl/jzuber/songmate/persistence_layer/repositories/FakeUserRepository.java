package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.exceptions.NoUsersInDatabase;
import pl.jzuber.songmate.exceptions.YouAskForToMuch;
import pl.jzuber.songmate.model.SongmateUser;
import pl.jzuber.songmate.utils.FakeUserGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("fakeUserRepo")
public class FakeUserRepository implements UserRepository {

    private Map<Long, SongmateUser> userMap;

    @Autowired
    FakeUserRepository(FakeUserGenerator fakeUserGenerator) {
        this.userMap = new TreeMap<>();
        fakeUserGenerator.getUserList(20).stream()
                                                    .filter(user -> !userMap.containsKey(user.getId()))
                                                    .forEach(user -> userMap.put(user.getId(), user));
    }

    @Override
    public List<SongmateUser> findAllByOrderByIdAsc() {
        System.out.println("returns empty stream class = " + this.getClass().getName());
        return Collections.EMPTY_LIST;
    }

    @Override
    public Stream<SongmateUser> getRandomUsers(Long how_many_users) throws NoUsersInDatabase {
        if(how_many_users > userMap.size()) throw new YouAskForToMuch("Number of users in db is too small. You ask for to much.");
        Collection<SongmateUser> songmateUsers = userMap.values();
        List<SongmateUser> usersList = new ArrayList(songmateUsers);
        Collections.shuffle(usersList);
        return usersList.stream().limit(how_many_users);
    }

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
    public List<SongmateUser> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
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
