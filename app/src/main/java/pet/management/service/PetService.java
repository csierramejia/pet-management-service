package pet.management.service;

import pet.management.model.Pet;
import pet.management.repository.PetRepository;
import javax.inject.Inject;
import java.util.List;

public class PetService {

    @Inject
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.getAllPets();
    }

    public void registerPet(Pet pet) {
        petRepository.savePet(pet);
    }
}