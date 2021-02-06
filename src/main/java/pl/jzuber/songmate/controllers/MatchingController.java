package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.model.challenges.TrackRecommendationChallenge;
import pl.jzuber.songmate.persistence_layer.daos.ChallengeDao;

import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api")
public class MatchingController {

    ChallengeDao challengeDao;

    @Autowired
    public MatchingController(ChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @PostMapping("/custom") /* TODO czy da sie to zapisywac do db, czy to ma sens byc takie*/
    public Challenge customController(@RequestBody Challenge challenge) throws Exception {
        if (challenge.getClass().getName() == "pl.jzuber.songmate.model.challenges.SendMeSongChallenge") {
            System.out.println("\n"+(SendMeSongChallenge)challenge);
            return challenge;
        }
        return null;
    }

    @GetMapping(value = "/getChallenge", produces = {"application/json"})
    @Profile("dev")
    public Challenge getMockChallenge() {
        return new TrackRecommendationChallenge(
                new Random().nextLong(),
                "TrackRecomendationChallenge",
                null,
                null,
                "6AH462-zuIg"
        );
    }


}
