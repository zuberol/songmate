package pl.jzuber.songmate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO refactor it to reactive


@Controller
@RequestMapping("/app")
//@PreAuthorize("hasRole('ROLE_STUDENT')")  //has_authority
public class AppController {

//    @RequestMapping("")
//    String getWelcome(){
//        return "/app/welcome";
//    }

}
