package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.model.challenges.TrackRecomendationChallenge;
import pl.jzuber.songmate.persistence_layer.daos.ChallengeDao;

import java.util.Random;

@RestController("/app")
public class MatchingController {

    ChallengeDao challengeDao;

    @Autowired
    public MatchingController(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @PostMapping("/custom")
    public Challenge customController(@RequestBody Challenge challenge) throws Exception {
        if (challenge.getClass().getName() == "pl.jzuber.songmate.model.challenges.SendMeSongChallenge") {
            System.out.println("\n"+(SendMeSongChallenge)challenge);
            return challenge;
        }
        return null;
    }

    @GetMapping(value = "/getChallenge", produces = {"application/json"})
    public Challenge customController() {
        return new TrackRecomendationChallenge(new Random().nextLong(), "TrackRecomendationChallenge", null, null, "6AH462-zuIg");
    }


}
