package pl.jzuber.songmate.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.jzuber.songmate.security.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    //@UniqueConstraint()
    @Column(unique = true)
    private String username;
    private String password;

    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;

    @Column(name = "enabled", unique = true)
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {            // TODO
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Enumerated(EnumType.STRING) 
    @ElementCollection
    @CollectionTable(name = "role") //fetch = FetchType.EAGER
//    @JoinTable("user_entity")     //TODO add Role to users table
    private Set<Role> role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;        // TODO hash(password)
    }

    public void setPasswordHash(String passwordHash) {
        this.password = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Set<Role> getRole() {
        return role;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }
}
