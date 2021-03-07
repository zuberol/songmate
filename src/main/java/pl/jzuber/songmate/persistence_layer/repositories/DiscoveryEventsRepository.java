package pl.jzuber.songmate.persistence_layer.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jzuber.songmate.services.DiscoveryService.discoveryEvents.DiscoveryEvent;

public abstract class DiscoveryEventsRepository implements CrudRepository<DiscoveryEvent, Long> {
}
