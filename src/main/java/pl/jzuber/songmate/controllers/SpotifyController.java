package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SearchResult;
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
@RequestMapping("/api/spotify")
public class SpotifyController {


    @RequestMapping("/search/{trackName}")
    public SearchResult searchForItem(@PathVariable("trackName") String trackName, @RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient)
            throws ParseException, SpotifyWebApiException, IOException {
        return new SpotifyApi.Builder()
                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                .build().searchItem(trackName, ModelObjectType.TRACK.type).build().execute();
    }

}

