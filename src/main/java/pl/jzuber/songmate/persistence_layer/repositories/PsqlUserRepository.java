package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.User;
import java.util.stream.Stream;

@Repository(value = "psqlUserRepo")
public interface PsqlUserRepository extends UserRepository {

}
