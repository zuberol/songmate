package pl.jzuber.songmate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests((authorizeRequests) ->
//                        authorizeRequests
//                                .anyRequest().authenticated()
//                )
//                .oauth2Client(withDefaults());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().disable()
//                .authorizeRequests(authorize -> authorize
////                        .antMatchers("/app/artists").permitAll()
////                        .mvcMatchers("/app/artists").permitAll()
//                        .anyRequest().authenticated()
//                )
                .authorizeRequests(authorize -> authorize
//                                .antMatchers("/app/user/fakeMe").permitAll() // TODO delete that, after connecting back-and-front end
                                .antMatchers("/unsecured/**").permitAll() // This will be your home screen URL
//                        .antMatchers("/css/**").permitAll()
//                        .antMatchers("/js/**").permitAll()
                                .antMatchers("/app**").authenticated()
                                .anyRequest().authenticated()
                )
                .oauth2Client(oauth2 -> oauth2
                        .clientRegistrationRepository(this.clientRegistrationRepository())
//                        .authorizedClientRepository(this.authorizedClientRepository())
//                        .authorizedClientService(this.authorizedClientService())
                                .authorizationCodeGrant(withDefaults())
//                        .authorizationCodeGrant(codeGrant -> codeGrant.
//                                .authorizationRequestRepository(this.authorizationRequestRepository())
//                                .authorizationRequestResolver(this.authorizationRequestResolver())
//                                .accessTokenResponseClient(this.accessTokenResponseClient())
//                        )
                );
    }


//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .requestMatchers()
//                .antMatchers("/api/**")
//                .and()
//                .requestMatchers()
//                .antMatchers("/oauth/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").hasRole("USER")
//                .and()
//                .httpBasic();
//    }
//
//
//
//







//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService(
//            ClientRegistrationRepository clientRegistrationRepository) {
//        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
//    }
//
//    @Bean
//    public OAuth2AuthorizedClientRepository authorizedClientRepository(
//            OAuth2AuthorizedClientService authorizedClientService) {
//        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
//    }

//    @Bean
//    public OAuth2AuthorizedClientManager authorizedClientManager(
//            ClientRegistrationRepository clientRegistrationRepository,
//            OAuth2AuthorizedClientRepository authorizedClientRepository) {
//
//        OAuth2AuthorizedClientProvider authorizedClientProvider =
//                OAuth2AuthorizedClientProviderBuilder.builder()
//                        .authorizationCode()
//                        .refreshToken()
//                        .clientCredentials()
//                        .password()
//                        .build();
//
//        DefaultOAuth2AuthorizedClientManager authorizedClientManager =
//                new DefaultOAuth2AuthorizedClientManager(
//                        clientRegistrationRepository, authorizedClientRepository);
//        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
//
//        return authorizedClientManager;
//    }

        //co sie stanie po udanej Autoryzacji
//    setAuthorizationSuccessHandler(OAuth2AuthorizationSuccessHandler) and setAuthorizationFailureHandler(OAuth2AuthorizationFailureHandler).









    final static String REGISTRATION_ID = "spotify";
    final static String CLIENT_ID = "86594ad446164e8ba2b311639e5d60a6";
    final static String CLIENT_SECRET = "e80c65abbc85467aafa35b762fc8832f";
    final static String SPOTIFY_AUTH_URL = "https://accounts.spotify.com/authorize";
    final static String SPOTIFY_AUTH_TOKEN_URL = "https://accounts.spotify.com/api/token";
    final static String REDIRECT_URL = "{baseUrl}/{action}/oauth2/code/{registrationId}";   //"http://localhost:3000";

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.spotifyClientRegistration());
    }

    private ClientRegistration spotifyClientRegistration() {
        return ClientRegistration.withRegistrationId(REGISTRATION_ID)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate(REDIRECT_URL)
                .scope("user-read-email", "user-follow-read", "user-read-private")
                .authorizationUri(SPOTIFY_AUTH_URL)
                .tokenUri(SPOTIFY_AUTH_TOKEN_URL)
                .clientName("Spotify")
                .build();
    }


}
