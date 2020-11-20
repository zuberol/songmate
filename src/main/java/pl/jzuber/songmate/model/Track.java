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
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long track_id;

    private String href;                // A link to the Web API endpoint providing full details of the track.
    private String name;                // Track name.
    private String uri;                 // Uri to play this track.
    private Integer duration_ms;        // Track duration in [ms].


}
