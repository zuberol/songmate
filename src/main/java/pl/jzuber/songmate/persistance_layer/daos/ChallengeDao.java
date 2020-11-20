package pl.jzuber.songmate.persistance_layer.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.persistance_layer.repositories.ChallengeRepository;


@Repository
public class ChallengeDao {

    public ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeDao(@Qualifier("fakeChallengeRepo") ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

}
