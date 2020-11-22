package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.persistance_layer.daos.ChallengeDao;

@RestController//("/matches")
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

}
