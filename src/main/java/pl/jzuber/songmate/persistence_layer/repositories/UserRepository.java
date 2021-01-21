package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jzuber.songmate.model.User;

import java.util.List;
import java.util.stream.Stream;


public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByOrderByIdAsc();
    default Stream<User> getRandomUsers(Long how_many_users) {
        return findAllByOrderByIdAsc().stream();
    };
}
