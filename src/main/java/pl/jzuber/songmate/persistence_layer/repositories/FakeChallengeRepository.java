package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.utils.FakeChallengeGenerator;

import java.util.*;
import java.util.stream.Collectors;

@Repository("fakeChallengeRepo")
public class FakeChallengeRepository extends ChallengeRepository {

    private Map<Long, Challenge> challengeMap;
    private Random rand = new Random();
    private long sequence = 0;

    @Autowired
    public FakeChallengeRepository(FakeChallengeGenerator fakeChallengeGenerator) {
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
    public <S extends Challenge> S save(S s) {
        long notTaken = getSequence();
        while(challengeMap.containsKey(notTaken)) notTaken = getSequence();
        challengeMap.put(notTaken, s);
        return s;
    }

    @Override
    public <S extends Challenge> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Challenge> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Challenge> findAll() {
        return null;
    }

    @Override
    public Iterable<Challenge> findAllById(Iterable<Long> iterable) {
        return null;
    }

        public List<Challenge> findAllById(Long id) {
        return challengeMap.values().stream().filter(rec -> rec.getAddressee().getId() == id).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Challenge challenge) {

    }

    @Override
    public void deleteAll(Iterable<? extends Challenge> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
