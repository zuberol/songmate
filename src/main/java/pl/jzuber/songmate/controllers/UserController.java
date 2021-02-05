package pl.jzuber.songmate.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/me/name", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET, produces = "application/json")
    public static String getAccToken(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) {
        final OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        if(accessToken == null) throw new RuntimeException("accessToken is null");
        return accessToken.getTokenValue();
    }


    //uzyc ClientRegistration z ClientRegistrationRepository
    @RequestMapping(value = "/scopes", method = RequestMethod.GET, produces = "application/json")
    public static Set<String> getScopes(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient) {
        final OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        if(accessToken == null) throw new RuntimeException("accessToken is null");
        final Set<String> scopes = accessToken.getScopes();
        if(scopes == null) throw new RuntimeException("scopes is null");
        return scopes;
    }

    @RequestMapping(value = "/authorities", method = RequestMethod.GET, produces = "application/json")
    public static List<? extends GrantedAuthority> getGAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream().collect(Collectors.toList());
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/json")
    public String readEmail(Authentication authentication) {
        return authentication.getName();
    }
    @RequestMapping(value = "/pread", method = RequestMethod.GET, produces = "application/json")
    public String privateReadEmail(Authentication authentication) {
        return authentication.getName();
    }



//    @RequestMapping(value = "/username1", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public String currentUserNameSimpleExample(HttpServletRequest request) {
//        Principal principal = request.getUserPrincipal();
//        return principal.getName();
//    }

//    @RequestMapping(value = "/username2", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserNameExample(Authentication authentication) {
//        return authentication.getName();
//    }


//    @RequestMapping(value = "/authorities", method = RequestMethod.GET, produces = "application/json")
//    public static Collection<? extends GrantedAuthority> getAuthorities(DefaultOAuth2User client) {
//        if(client.getAuthorities() == null) throw new RuntimeException("authorities were null object");
//        return client.getAuthorities();
//    }



//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public Iterable<User> getAllUsers(){
//        userService.userDao.findAll().forEach(System.out::println);
//        return userService.userDao.findAll();
//    }
//
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public static com.wrapper.spotify.model_objects.specification.User
    getCurrentUsersProfile_Sync(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient)
    throws IOException, SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
                .build();
        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
            return getCurrentUsersProfileRequest.execute();
    }


//    @RequestMapping(value = "/me", method = RequestMethod.GET)
//    public static com.wrapper.spotify.model_objects.specification.User
//    getCurrentUsersProfile_Sync(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient,
//                                @RequestHeader Map<String, String> headers) {
//
//        headers.forEach((key, value) -> {
//            System.out.println(String.format("Header '%s' = %s", key, value));
//        });
//
//        System.out.println("user token is: " + authorizedClient.getAccessToken().getTokenValue());
//        SpotifyApi spotifyApi = new SpotifyApi.Builder()
//                .setAccessToken(authorizedClient.getAccessToken().getTokenValue())
//                .build();
//        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
//                .build();
//        try {
//            com.wrapper.spotify.model_objects.specification.User user = getCurrentUsersProfileRequest.execute();
//            System.out.println("Display name: " + user.getDisplayName());
//            return user;
//        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        return new com.wrapper.spotify.model_objects.specification.User.Builder().build();
//    }













//
//    @RequestMapping(value = "/fakeMe")
//    public User getUsername(@RequestHeader Map<String, String> headers, Authentication authentication) {
//        headers.forEach((key, value) -> {
//            System.out.println(String.format("Header '%s' = %s", key, value));
//        });
//        return User.builder().username("Jakubix").build();
//    }

}
