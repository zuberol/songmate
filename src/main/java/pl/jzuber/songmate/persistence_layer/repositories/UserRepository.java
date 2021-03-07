package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.model.SongmateUser;

import java.util.List;
import java.util.stream.Stream;


public interface UserRepository extends CrudRepository<SongmateUser, Long> {
    List<SongmateUser> findAllByOrderByIdAsc();
    default Stream<SongmateUser> getRandomUsers(Long how_many_users) {
        return findAllByOrderByIdAsc().stream();
    };
}
