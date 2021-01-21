package pl.jzuber.songmate.model;

import lombok.*;
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
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@UniqueConstraint()
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "enabled")
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private String email;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "role") //fetch = FetchType.EAGER
    private Set<Role> role;

    @Override   //todo zmienic to bo auth nie zadziala
    public Collection<? extends GrantedAuthority> getAuthorities() {            // TODO return a list of authorities
        return Collections.emptyList();
    }

    @Override
    public String toString(){
        return this.username + " " + this.id;
    }

}
