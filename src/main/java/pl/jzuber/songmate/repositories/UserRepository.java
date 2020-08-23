package pl.jzuber.songmate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.User;

@Repository//("test")
public interface UserRepository  <T, ID> extends CrudRepository<User, Long> {
}