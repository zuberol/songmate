package pl.jzuber.songmate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.persistance_layer.daos.ChallengeDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ChallengeService {

    public ChallengeDao challengeDao;
    public Map<String, String> challengeMap;

    @Autowired
    public ChallengeService(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
        this.challengeMap = new TreeMap();
        challengeMap.put("SendMeSongChallenge", "pl.jzuber.songmate.model.challenges.SendMeSongChallenge");
    }
}
