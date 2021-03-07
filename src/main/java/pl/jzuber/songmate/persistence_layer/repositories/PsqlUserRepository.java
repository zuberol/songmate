package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.stereotype.Repository;

@Repository(value = "psqlUserRepo")
public interface PsqlUserRepository extends UserRepository {

}
