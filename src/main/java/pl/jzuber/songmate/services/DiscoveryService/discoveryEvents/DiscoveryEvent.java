package pl.jzuber.songmate.services.DiscoveryService.discoveryEvents;

import javax.persistence.*;

import lombok.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.experimental.SuperBuilder;
import pl.jzuber.songmate.model.SongmateUser;
import pl.jzuber.songmate.utils.CustomChallengeDeserializer;

import java.sql.Timestamp;

@MappedSuperclass
@JsonDeserialize(using = CustomChallengeDeserializer.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@SuperBuilder
public abstract class DiscoveryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    public SongmateUser assignee;
    @ManyToOne
    public SongmateUser creator;
    public Timestamp created;
    public Timestamp finished;



}