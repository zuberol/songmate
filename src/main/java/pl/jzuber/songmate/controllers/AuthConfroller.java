package pl.jzuber.songmate.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthConfroller {

    @GetMapping(value = "/authInfo", produces = "application/json")
    @Profile("dev")
    public List<Object> tokens(Authentication authentication){
        if(authentication == null) return Collections.emptyList();
        return List.of(authentication.getName(), authentication.getCredentials(), authentication.getDetails(), authentication.getCredentials());
    }

}
