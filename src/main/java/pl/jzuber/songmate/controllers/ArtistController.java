package pl.jzuber.songmate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;


@RestController
@RequestMapping("/unsecured")
public class ArtistController {
    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public Iterable<Artist> getArtists(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient,
                                       @AuthenticationPrincipal OAuth2User oauth2User){
        System.out.println(authorizedClient.getAccessToken().toString());
        try {
            System.out.println(authorizedClient.getPrincipalName());
        } catch (NullPointerException e) {
            System.out.println("null");
        }
        return artistService.getArtists();
    }

    @GetMapping("/dummy")
    public Iterable<Artist> dummyEndpointUnsecured(){
        return artistService.getArtists();
    }

}
