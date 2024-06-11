package pet.management.service;

import pet.management.model.Pet;
import pet.management.repository.PetRepository;
import pet.management.exception.ServiceException;
import pet.management.exception.RepositoryException;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetService {

    @Inject
    private PetRepository petRepository;

    public List<Pet> getAllPets() {

        try {
            return petRepository.getAllPets();
        } catch (RepositoryException e) {
            throw new ServiceException("Unable to retrieve pets", e);
        }
    }

    public Pet findById(String id) {
        try {
            return petRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException("Unable to retrieve pet", e);
        }
    }

    public void registerPet(Pet pet) {
        petRepository.savePet(pet);
    }
}