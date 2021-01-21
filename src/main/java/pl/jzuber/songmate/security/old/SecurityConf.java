package pl.jzuber.songmate.security.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import static pl.jzuber.songmate.security.Role.*;
//
//@Configuration
////@EnableWebSecurity    //todo ogarnac co to robi jedno i drugie
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConf extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final JdbcDaoImpl jdbcDao;      //todo potrzebne to?

    @Autowired
    public SecurityConf(PasswordEncoder passwordEncoder, JdbcDaoImpl jdbcDao) {
        this.passwordEncoder = passwordEncoder;
        this.jdbcDao = jdbcDao;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1).expiredUrl("/session-expired.html")
                .and().and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/user","/user/**").permitAll()
                .antMatchers("/matches/**").permitAll()
                .antMatchers("/app/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                    //.successForwardUrl("/app")
                    .failureForwardUrl("/login/error")
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID");
    }



//    @Bean
//    public SessionRegistry sessionRegistry() {
//        SessionRegistry sessionRegistry = new SessionRegistryImpl();
//        return sessionRegistry;
//    }
//
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }


}
