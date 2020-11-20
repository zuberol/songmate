package pl.jzuber.songmate.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.persistance_layer.daos.UserDao;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class FakeChallengeGenerator {
    final static Random rand = new Random();
    private static UserDao userDao;

    @Autowired
    public FakeChallengeGenerator(UserDao userDao) {
        this.userDao = userDao;
    }

    public static Challenge generateRandChallenge() {
        List<User> randUsers = userDao.getRandomUsers(2L).collect(Collectors.toList());
        return new SendMeSongChallenge(Math.abs(rand.nextLong()), randUsers.get(0), randUsers.get(1));
    }

    // may return smaller ammount of challenges in case of exception
    public static List<Challenge> generateRandChallengeList(long list_len) {
        List<Challenge> fillWithChallenges = new LinkedList<>();
        for(int i=0; i< list_len; ++i){
            Challenge ch = generateRandChallenge();
            if(ch != null) fillWithChallenges.add(ch);
            else return fillWithChallenges;
        }

        return fillWithChallenges;
    }

}
