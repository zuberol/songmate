package pl.jzuber.songmate.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.model.User;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.mapping.Table;

//R2dbcRepository extends ReactiveCrudRepository
public interface UserRepository  extends R2dbcRepository<User, Long> {
}