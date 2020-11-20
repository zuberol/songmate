package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<User> getAllUsers(){
        userService.userDao.findAll().forEach(System.out::println);
        return userService.userDao.findAll();
    }

//    @PostMapping
//    //@Validated
//    public String changePassword(@RequestBody ChangePasswordForm form){
//
//        //before check if form.getUsername() == this.user
//        userService.changeUserPassword(form.getUsername(), form.getPassword());
//
//        return "wat";
//    }

}
