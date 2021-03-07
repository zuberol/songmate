package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoveryEvent;
import pl.jzuber.songmate.utils.FakeChallengeGenerator;

import java.util.*;

@Repository("fakeChallengeRepo")
public class FakeDiscoveryEventsRepository extends DiscoveryEventsRepository {

    private Map<Long, DiscoveryEvent> challengeMap;
    private Random rand = new Random();
    private long sequence = 0;

    @Autowired
    public FakeDiscoveryEventsRepository(FakeChallengeGenerator fakeChallengeGenerator) {
        this.challengeMap = new TreeMap<>();
        fakeChallengeGenerator.generateRandChallengeList(1)
                .stream()
                .filter(ch -> !challengeMap.containsKey(ch.getId()))
                .forEach(ch -> challengeMap.put(ch.getId(), ch));
//        challengeMap.values().stream().forEach(System.out::println);


    }

    long getSequence() {
        return ++this.sequence;
    }

    @Override
    public <S extends DiscoveryEvent> S save(S s) {
        long notTaken = getSequence();
        while(challengeMap.containsKey(notTaken)) notTaken = getSequence();
        challengeMap.put(notTaken, s);
        return s;
    }

    @Override
    public <S extends DiscoveryEvent> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<DiscoveryEvent> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<DiscoveryEvent> findAll() {
        return null;
    }

    @Override
    public Iterable<DiscoveryEvent> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DiscoveryEvent discoveryEvent) {

    }

    @Override
    public void deleteAll(Iterable<? extends DiscoveryEvent> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
