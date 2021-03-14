package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.services.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/scopes", method = RequestMethod.GET)
    @Profile("dev")
    public Set<String> getCurrentUserScopes(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) {
        final OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        if(accessToken == null) throw new RuntimeException("accessToken is null");
        final Set<String> scopes = accessToken.getScopes();
        if(scopes == null) throw new RuntimeException("scopes are null");
        return scopes;
    }

    @RequestMapping(value = "/authorities", method = RequestMethod.GET)
    @Profile("dev")
    public static List<? extends GrantedAuthority> getGAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream().collect(Collectors.toList());
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User getCurrentUsersProfile_Sync(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient)
                                    throws IOException, SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        return new SpotifyApi.Builder()
                                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                                .build()
                                .getCurrentUsersProfile()
                                .build()
                                .execute();
    }

}
