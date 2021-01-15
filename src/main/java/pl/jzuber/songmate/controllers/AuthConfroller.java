package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.jzuber.songmate.model.SpotifyAccessToken;
import pl.jzuber.songmate.model.messages.SpotifyAuthPrerequisite;
import pl.jzuber.songmate.persistance_layer.repositories.SpotifyAccessTokenRepository;

import java.sql.Timestamp;

@RestController
@RequestMapping("/auth")
public class AuthConfroller {

    SpotifyAccessTokenRepository spotifyAccessTokenRepository;

    @Autowired
    public AuthConfroller(SpotifyAccessTokenRepository spotifyAccessTokenRepository) {
        this.spotifyAccessTokenRepository = spotifyAccessTokenRepository;
    }

    @PostMapping(value = "/spotifyAuthPrerequisite")
    ResponseEntity readAuthPrerequisite(@RequestBody SpotifyAuthPrerequisite spotifyAuthPrerequisite) {
        System.out.println("spotifyAuthPrerequisite is: " + spotifyAuthPrerequisite.toString());


        //TODO Get token using spotifyAuthPrerequisite
//        SpotifyAccessToken spotifyAccessToken = SpotifyAccessToken.builder()
//                .access_token(spotifyAuthPrerequisite.CODE)
//                .created(new Timestamp(1000L))
//                .build();
//        spotifyAccessTokenRepository.save(spotifyAccessToken);
        if(spotifyAuthPrerequisite.isValid()) return new ResponseEntity<>(HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
