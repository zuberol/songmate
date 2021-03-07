package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoveryEvent;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoverSong;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.TrackRecommendationDiscoveryEvent;
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
    public DiscoveryEvent customController(@RequestBody DiscoveryEvent discoveryEvent) throws Exception {
        if (discoveryEvent.getClass().getName() == "pl.jzuber.songmate.model.challenges.SendMeSongChallenge") {
            System.out.println("\n"+(DiscoverSong) discoveryEvent);
            return discoveryEvent;
        }
        return null;
    }

    @GetMapping(value = "/getChallenge", produces = {"application/json"})
    @Profile("dev")
    public DiscoveryEvent getMockChallenge() {
        return new TrackRecommendationDiscoveryEvent();
    }


}
