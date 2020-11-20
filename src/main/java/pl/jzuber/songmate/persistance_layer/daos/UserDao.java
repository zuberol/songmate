package pl.jzuber.songmate.persistance_layer.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.jzuber.songmate.exceptions.NoUsersInDatabase;
import pl.jzuber.songmate.exceptions.YouAskForToMuch;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.persistance_layer.repositories.UserRepository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


/* Musi to byc concrete class, bo to nam pozwala podmieniac repozytoria w tym miejscu.
*  Docelowo tu ma być tylko wywołana metoda na userRepository. Możemy dzięki temu ograniczyć dostęp też do niektórych metod z repozytorium.
*  Można tutaj zmienić typ danych zwracanych łatwo.
*  Może dobrym pomysłem jest zrobić z tego abstract klase? */
@Repository
public class UserDao {

    UserRepository userRepository;

    @Autowired
    public UserDao(@Qualifier("fakeUserRepo") UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Stream<User> getRandomUsers(Long numUsers){
        //return Collections.EMPTY_LIST.stream();
        return userRepository.getRandomUsers(numUsers);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


//    public Stream<User> getRandomUsers(Long how_many_users) throws NoUsersInDatabase {
//        if(how_many_users > userMap.size()) throw new YouAskForToMuch("Number of users in db is too small. You ask for to much.");
//        Collection<User> users = userMap.values();
//        List<User> usersList = new ArrayList(users);
//        Collections.shuffle(usersList);
//        return usersList.stream().limit(how_many_users);
//    }






}
