package pl.jzuber.songmate.persistence_layer.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>, RandomEntity<Animal> {
//    public abstract void abstractToOverride();
    default void hello() {
        System.out.println("hello from " + this.getClass());

    }   //todo delete that
}
