package pl.jzuber.songmate.persistence_layer.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.persistence_layer.repositories.DiscoveryEventsRepository;


@Repository
public class ChallengeDao {

    public DiscoveryEventsRepository discoveryEventsRepository;

    @Autowired
    public ChallengeDao(@Qualifier("fakeChallengeRepo") DiscoveryEventsRepository discoveryEventsRepository) {
        this.discoveryEventsRepository = discoveryEventsRepository;
    }

}
