package pet.management.repository;

import pet.management.model.Pet;
import java.util.List;


public interface PetRepository {
    public Pet findById(String  id);
    public List<Pet> getAllPets();
    public void savePet(Pet pet);
}