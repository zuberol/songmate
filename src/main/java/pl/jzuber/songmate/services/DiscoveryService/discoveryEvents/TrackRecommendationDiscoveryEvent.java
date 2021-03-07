package pl.jzuber.songmate.services.DiscoveryService.discoveryEvents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public final class TrackRecommendationDiscoveryEvent extends DiscoveryEvent {


}
