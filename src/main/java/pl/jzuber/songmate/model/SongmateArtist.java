package pl.jzuber.songmate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class SongmateArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String href;                // A link to the Web API endpoint providing full details of the artist.
    private String spotify_id;          //	The Spotify ID for the artist.
    private String name;               //  The name of the artist.
    private String uri;                 //	string	The Spotify URI for the artist.

    public SongmateArtist(String name) {
        this.name = name;
    }
}
