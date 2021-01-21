package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.model.challenges.Challenge;

public abstract class ChallengeRepository implements CrudRepository<Challenge, Long> {
}
