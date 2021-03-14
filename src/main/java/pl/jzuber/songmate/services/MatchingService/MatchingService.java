package pl.jzuber.songmate.services.MatchingService;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jzuber.songmate.persistence_layer.daos.ChallengeDao;
import pl.jzuber.songmate.services.UserService;

public class MatchingService {

    private UserService userService;
    private ChallengeDao challengeDao;

    @Autowired
    public MatchingService(UserService userService, ChallengeDao challengeDao) {
        this.userService = userService;
        this.challengeDao = challengeDao;
    }

}
