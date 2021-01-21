package pl.jzuber.songmate.persistence_layer.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.persistence_layer.repositories.ChallengeRepository;


@Repository
public class ChallengeDao {

    public ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeDao(@Qualifier("fakeChallengeRepo") ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

}
