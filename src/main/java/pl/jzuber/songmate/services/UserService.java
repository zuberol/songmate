package pl.jzuber.songmate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jzuber.songmate.persistance_layer.daos.UserDao;

@Service
public class UserService {
    public UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}
