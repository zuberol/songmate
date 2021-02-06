package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Paging;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/usersTopArtists", method = RequestMethod.GET)
    Paging<Artist> getTopArtists(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient)
                                    throws IOException, SpotifyWebApiException, ParseException {

        return new SpotifyApi.Builder()
                                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                                .build()
                                .getUsersTopArtists()
                                .build()
                                .execute();
    }

}
