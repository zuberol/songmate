package pl.jzuber.songmate.services.DiscoveryService.discoveryEvents;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.net.URL;
import java.util.Optional;


@Entity
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public final class DiscoverSong extends DiscoveryEvent {

    String songName;
    String messageFromCreator;

}
