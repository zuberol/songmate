package pl.jzuber.songmate.persistence_layer.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class AnimalDao {

    AnimalRepository animalRepository;

    @Autowired //  @Qualifier("psqlAnimalRepo")
    public AnimalDao(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
        Animal animal = new Animal();
        animal.setName("Arnold");
        animalRepository.save(animal);

        animalRepository.hello();
        //animalRepository.deleteCustomById();
    }
}
