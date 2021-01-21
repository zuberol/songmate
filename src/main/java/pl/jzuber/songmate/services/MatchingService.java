package pl.jzuber.songmate.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jzuber.songmate.persistence_layer.daos.ChallengeDao;

public class MatchingService {

    private UserService userService;
    private ChallengeDao challengeDao;

    @Autowired
    public MatchingService(UserService userService, ChallengeDao challengeDao) {
        this.userService = userService;
        this.challengeDao = challengeDao;
    }







}
