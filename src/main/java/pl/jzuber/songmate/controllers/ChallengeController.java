package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.model.challenges.TrackRecomendationChallenge;
import pl.jzuber.songmate.persistance_layer.daos.ChallengeDao;

import java.util.Random;

@RestController
public class ChallengeController {

    @GetMapping(value = "/getChallenge", produces = {"application/json"})
    public Challenge customController() {
        return new TrackRecomendationChallenge(new Random().nextLong(), "TrackRecomendationChallenge", null, null, "6AH462-zuIg");
    }

}
