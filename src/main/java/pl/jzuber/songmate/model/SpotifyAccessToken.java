package pl.jzuber.songmate.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SpotifyAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User bearer;
    private String access_token;
    private Timestamp created;
    private Timestamp expires;

}
