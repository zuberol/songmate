package pl.jzuber.songmate.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoveryEvent;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoverSong;
import pl.jzuber.songmate.model.SongmateUser;
import pl.jzuber.songmate.persistence_layer.daos.UserDao;

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

    public static DiscoveryEvent generateRandChallenge() {
        List<SongmateUser> randSongmateUsers = userDao.getRandomUsers(2L).collect(Collectors.toList());
        return new DiscoverSong();
    }

    // may return smaller ammount of challenges in case of exception
    public static List<DiscoveryEvent> generateRandChallengeList(long list_len) {
        List<DiscoveryEvent> fillWithDiscoveryEvents = new LinkedList<>();
        for(int i=0; i< list_len; ++i){
            DiscoveryEvent ch = generateRandChallenge();
            if(ch != null) fillWithDiscoveryEvents.add(ch);
            else return fillWithDiscoveryEvents;
        }

        return fillWithDiscoveryEvents;
    }

}
