package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.model.SpotifyAccessToken;
import pl.jzuber.songmate.model.messages.SpotifyAuthPrerequisite;
import pl.jzuber.songmate.persistence_layer.repositories.SpotifyAccessTokenRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AuthConfroller {

    SpotifyAccessTokenRepository spotifyAccessTokenRepository;      //TODO, to jeszcze nie podpiete jest

//    @Autowired
//    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    public AuthConfroller(SpotifyAccessTokenRepository spotifyAccessTokenRepository) {
        this.spotifyAccessTokenRepository = spotifyAccessTokenRepository;
    }

    @GetMapping(value = "/authInfo", produces = "application/json")
    public List<Object> tokens(Authentication authentication){
        if(authentication == null) return Collections.emptyList();
        return List.of(authentication.getName(), authentication.getCredentials(), authentication.getDetails(), authentication.getCredentials());
    }

//    @PostMapping("/spotifyAuthPrerequisite")
//    ResponseEntity readAuthPrerequisite(@RequestBody SpotifyAuthPrerequisite spotifyAuthPrerequisite) {
//        System.out.println("spotifyAuthPrerequisite is: " + spotifyAuthPrerequisite.toString());
//        //TODO Get token using spotifyAuthPrerequisite
////        SpotifyAccessToken spotifyAccessToken = SpotifyAccessToken.builder()
////                .access_token(spotifyAuthPrerequisite.CODE)
////                .created(new Timestamp(1000L))
////                .build();
////        spotifyAccessTokenRepository.save(spotifyAccessToken);
//        if(spotifyAuthPrerequisite.isValid()) return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }


    @GetMapping("/secured")
    public ResponseEntity index(Model model,
                        @RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient,
                        @AuthenticationPrincipal OAuth2User oauth2User) {
//        model.addAttribute("userNamezeauberg", oauth2User.getName());
//        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
//        model.addAttribute("userAttributes", oauth2User.getAttributes());
        System.out.println(authorizedClient.getPrincipalName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
//
//    @GetMapping("/secured")
//    public ResponseEntity index(@AuthenticationPrincipal OAuth2User oauth2User) {
//        System.out.println("authorizedClient.getAccessToken().toString() = " + oauth2User);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

}
