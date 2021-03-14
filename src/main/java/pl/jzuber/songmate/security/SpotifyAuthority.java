package pl.jzuber.songmate.security;

import org.springframework.security.core.GrantedAuthority;

public class SpotifyAuthority implements GrantedAuthority {
    private final String authority;

    SpotifyAuthority(GrantedAuthority authority) {
        this.authority = "SPOTIFY_SELF_" + authority.getAuthority();
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}