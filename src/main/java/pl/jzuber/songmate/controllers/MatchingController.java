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

//    @RequestMapping(value = "/post-challenge", consumes = "application/json", produces = "application/json")
//    void postChallenge(@RequestBody JsonNode values) {
//
//        System.out.println(values);
//
//        //challengeDao.challengeRepository.save(challenge);
//    }

//    @RequestMapping(value="/post-challenge", method = RequestMethod.POST)
//    public JsonNode index(@RequestBody JsonNode jsonNode) {
//        System.out.println("Received JSON:"+jsonNode.toString());
//        return jsonNode;
//    }

    @PostMapping("/custom")
    public void customController(@RequestBody Challenge challenge) throws Exception {
        System.out.println();
        System.out.println("New challenge is spotted: "  + challenge.getClass().getCanonicalName());
        System.out.println("Class name " + challenge.getClass().getName());
        System.out.println("Class name " + challenge.getClass().getSimpleName());
    }


}
