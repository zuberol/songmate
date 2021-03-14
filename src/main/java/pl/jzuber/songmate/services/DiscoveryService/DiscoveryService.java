package pl.jzuber.songmate.services.DiscoveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.persistence_layer.daos.ChallengeDao;

import java.util.Map;
import java.util.TreeMap;

@Service
public class DiscoveryService {

    public ChallengeDao challengeDao;
    public Map<String, String> challengeMap;

    @Autowired
    public DiscoveryService(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
        this.challengeMap = new TreeMap();
        challengeMap.put("SendMeSongChallenge", "pl.jzuber.songmate.model.challenges.SendMeSongChallenge");
    }
}
