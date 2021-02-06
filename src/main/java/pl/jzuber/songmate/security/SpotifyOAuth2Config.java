package pl.jzuber.songmate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SpotifyOAuth2Config extends WebSecurityConfigurerAdapter {

    final static String REGISTRATION_ID = "spotify";    // TODO do INNEGO pliku
    final static String CLIENT_ID = "86594ad446164e8ba2b311639e5d60a6";
    final static String CLIENT_SECRET = "e80c65abbc85467aafa35b762fc8832f";
    final static String SPOTIFY_AUTH_URL = "https://accounts.spotify.com/authorize";
    final static String SPOTIFY_AUTH_TOKEN_URL = "https://accounts.spotify.com/api/token";
    final static String REDIRECT_URL = "{baseUrl}/{action}/oauth2/code/{registrationId}";
    final static String USER_INFO_URL = "https://api.spotify.com/v1/me";
    final static String NAME_ATRIBUTE_NAME = "display_name";

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().and()
                .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()   //todo doczytac XSRF-TOKEN
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .oauth2Login(login -> login
                        .clientRegistrationRepository(this.clientRegistrationRepository())
                        .successHandler(this.customAuthenticationSuccessHandler())
                        .failureHandler(this.customAuthenticationFailureHandler())
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(authorities -> authorities
                                        .stream()
                                        .map(SpotifyAuthority::new)
                                        .collect(Collectors.toList())
                                )
                        )
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("http://localhost:3000")
                        .addLogoutHandler(new SecurityContextLogoutHandler())
                        .deleteCookies("JSESSIONID")
                );
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        return new SimpleUrlAuthenticationSuccessHandler("http://localhost:3000/app");
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler("http://localhost:3000/error");
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.spotifyClientRegistration());
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(
            ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }

    @Bean
    public ClientRegistration spotifyClientRegistration() {
        return ClientRegistration.withRegistrationId(REGISTRATION_ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate(REDIRECT_URL)
                .scope("user-read-email", "user-follow-read", "user-read-private","user-top-read")
                .authorizationUri(SPOTIFY_AUTH_URL)
                .tokenUri(SPOTIFY_AUTH_TOKEN_URL)
                .userInfoUri(USER_INFO_URL)
                .clientName("Spotify")
                .userNameAttributeName(NAME_ATRIBUTE_NAME)
                .build();
    }


}
