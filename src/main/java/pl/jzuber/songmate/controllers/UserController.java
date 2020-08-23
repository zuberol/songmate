package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.ChangePasswordForm;
import pl.jzuber.songmate.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
