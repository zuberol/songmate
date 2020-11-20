package pl.jzuber.songmate.persistance_layer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.exceptions.NoUsersInDatabase;
import pl.jzuber.songmate.exceptions.YouAskForToMuch;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.utils.FakeUserGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("fakeUserRepo")
public class FakeUserRepository extends UserRepository {

    private Map<Long, User> userMap;

    @Autowired
    FakeUserRepository(FakeUserGenerator fakeUserGenerator) {
        this.userMap = new TreeMap<>();
        fakeUserGenerator.getUserList(20).stream()
                                                    .filter(user -> !userMap.containsKey(user.getId()))
                                                    .forEach(user -> userMap.put(user.getId(), user));
    }

    @Override
    public Stream<User> getRandomUsers(Long how_many_users) throws NoUsersInDatabase {
        if(how_many_users > userMap.size()) throw new YouAskForToMuch("Number of users in db is too small. You ask for to much.");
        Collection<User> users = userMap.values();
        List<User> usersList = new ArrayList(users);
        Collections.shuffle(usersList);
        return usersList.stream().limit(how_many_users);
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
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
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
