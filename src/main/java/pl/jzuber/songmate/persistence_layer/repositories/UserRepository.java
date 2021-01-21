package pl.jzuber.songmate.persistance_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.User;

import java.util.stream.Stream;

public abstract class UserRepository implements CrudRepository<User, Long> {
    public abstract Stream<User> getRandomUsers(Long how_many_users);
}
