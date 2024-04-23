package pet.management.repository;

import pet.management.model.Pet;
import java.util.List;

public interface PetRepository {
    List<Pet> getAllPets();
    void savePet(Pet pet);
    // Otros métodos relacionados con la persistencia
}