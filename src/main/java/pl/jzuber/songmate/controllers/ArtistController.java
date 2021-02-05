package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.Artist;
import pl.jzuber.songmate.services.ArtistService;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/artists")
public class ArtistController {
    final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

//    @GetMapping("/notAuthenticated")
//    public Iterable<Artist> getArtists(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient,
//                                       @AuthenticationPrincipal OAuth2User oauth2User){
//        System.out.println(authorizedClient.getAccessToken().toString());
//        try {
//            //oauth2User.getAuthorities().forEach(System.out::println);
//        } catch (NullPointerException e) {
//            System.out.println("null");
//        }
//        return artistService.getArtists();
//    }
    @GetMapping("/withRole")
    public Iterable<Artist> getArtists(){
        return artistService.getArtists();
    }

    @GetMapping("/artists")
    public Iterable<Artist> dummyEndpointUnsecured(){
        return artistService.getArtists();
    }

    @RequestMapping(value = "/usersTopArtists", method = RequestMethod.GET)
    Paging<com.wrapper.spotify.model_objects.specification.Artist> getTopArtists(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient)
                                    throws IOException, SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                .build();
        GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists().build();
        return getUsersTopArtistsRequest.execute();
    }


}
