package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.services.UserService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/app/user")
public class UserController {

    @Autowired  //todo wstrzyknac konstruktorem
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<User> getAllUsers(){
        userService.userDao.findAll().forEach(System.out::println);
        return userService.userDao.findAll();
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public static com.wrapper.spotify.model_objects.specification.User
        getCurrentUsersProfile_Sync(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient,
                                    @RequestHeader Map<String, String> headers) {

        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        System.out.println("user token is: " + authorizedClient.getAccessToken().getTokenValue());
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                .build();
        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        try {
            com.wrapper.spotify.model_objects.specification.User user = getCurrentUsersProfileRequest.execute();
            System.out.println("Display name: " + user.getDisplayName());
            return user;
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return new com.wrapper.spotify.model_objects.specification.User.Builder().build();
    }

    @RequestMapping(value = "/fakeMe")
    public User getUsername(@RequestHeader Map<String, String> headers, Authentication authentication) {
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
        //System.out.println(authentication.isAuthenticated());
        return User.builder().username("Jakubix").build();
    }


//    @RequestMapping("/fakeMe")
//    public String fakeRedirection(@RequestHeader Map<String, String> headers) {
//        headers.forEach((key, value) -> {
//            System.out.println(String.format("Header '%s' = %s", key, value));
//        });
//        return "Jakubek";
//    }



}
