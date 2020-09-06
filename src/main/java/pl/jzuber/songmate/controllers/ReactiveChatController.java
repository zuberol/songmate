package pl.jzuber.songmate.controllers;

import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jzuber.songmate.model.User;
import reactor.core.publisher.Mono;

/*
*   Musi byc route za pomoca parametru w URLu
*
*
*
* */


@Controller
public class ReactiveChatController {

    @RequestMapping("/app/chat")
    String getChat(){
        return "testing/chat";
    }

}
