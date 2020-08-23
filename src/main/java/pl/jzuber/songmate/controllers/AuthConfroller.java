package pl.jzuber.songmate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthConfroller {

    @RequestMapping("/login")
    public String loginThroughForm(Model model){
        return "security/login";
    }

    @GetMapping("/login/spotify")
    public RedirectView loginThroughSpotify(RedirectAttributes attributes){
            //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
            attributes.addAttribute("code", "someCodeIwillChangeLater");
        return new RedirectView("spotifyRedirectURI");
    }

    @RequestMapping("/login/error")
    public String errorMapping(Model model){
        return "/security/bad-login";
    }

}
