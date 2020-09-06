package pl.jzuber.songmate.model;


import org.springframework.data.annotation.Id;


public class Artist {

    @Id
    private Long id;

    private String href;                // A link to the Web API endpoint providing full details of the artist.
    private String spotify_id;          //	The Spotify ID for the artist.
    private String name;               //  The name of the artist.
    private String uri;                 //	string	The Spotify URI for the artist.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSpotify_id() {
        return spotify_id;
    }

    public void setSpotify_id(String spotify_id) {
        this.spotify_id = spotify_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
