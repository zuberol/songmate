package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.repositories.UserRepository;
import reactor.core.publisher.Flux;


//TODO refactor it to reactive


@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAllCities() {
        return userRepository.findAll();
    }




//    @PostMapping
//    @Validated
//    public String changePassword(@RequestBody ChangePasswordForm form){
//
//        //before check if form.getUsername() == this.user
//        userService.changeUserPassword(form.getUsername(), form.getPassword());
//
//        return "wat";
//    }

}
