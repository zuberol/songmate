package pl.jzuber.songmate.persistence_layer.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class RandomEntityImpl implements RandomEntity<Animal>{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteCustomById(Animal itemType) {
        entityManager.remove(itemType);
    }
}
