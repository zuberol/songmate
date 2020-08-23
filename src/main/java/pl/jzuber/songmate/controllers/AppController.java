package pl.jzuber.songmate.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
@PreAuthorize("hasRole('ROLE_STUDENT')")  //has_authority
public class AppController {

    @RequestMapping("")
    String getWelcome(){
        return "/app/welcome";
    }

}
