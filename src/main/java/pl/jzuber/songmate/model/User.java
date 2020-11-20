package pl.jzuber.songmate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.jzuber.songmate.security.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User implements UserDetails {

    //@UniqueConstraint()
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "enabled", unique = true)
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "role") //fetch = FetchType.EAGER
//    @JoinTable("user_entity")     //TODO add Role to users table
    private Set<Role> role;



    private User(String username, String password, boolean isEnabled, boolean isCredentialsNonExpired, boolean isAccountNonLocked, boolean isAccountNonExpired, Set<Role> role, Long id) {
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.role = role;
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {            // TODO return a list of authorities
        return Collections.emptyList();
    }

    @Override
    public String toString(){
        return this.username + " " + this.id;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private boolean isCredentialsNonExpired;
        private boolean isAccountNonLocked;
        private boolean isAccountNonExpired;
        private boolean isEnabled;
        private static Long id;
        private Set<Role> role;

        public User build() {
            return new User(
                    this.username,
                    this.password,
                    this.isEnabled,
                    this.isCredentialsNonExpired,
                    this.isAccountNonLocked,
                    this.isAccountNonExpired,
                    this.role,
                    this.id
            );
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setCredentialsNonExpired(boolean credentialsNonExpired) {
            isCredentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public UserBuilder setAccountNonLocked(boolean accountNonLocked) {
            isAccountNonLocked = accountNonLocked;
            return this;
        }

        public UserBuilder setAccountNonExpired(boolean accountNonExpired) {
            isAccountNonExpired = accountNonExpired;
            return this;
        }

        public UserBuilder setEnabled(boolean enabled) {
            isEnabled = enabled;
            return this;
        }

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setRole(Set<Role> role) {
            this.role = role;
            return this;
        }
    }

}
