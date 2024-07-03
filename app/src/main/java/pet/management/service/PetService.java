package pet.management.service;

import pet.management.model.Pet;
import pet.management.repository.PetRepository;
import pet.management.exception.ServiceException;
import pet.management.exception.RepositoryException;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class PetService {

    @Inject
    private PetRepository petRepository;

    @ConfigProperty(name = "quarkus.http.port")
    private String port;

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

    public List<Pet> findPets(){
        List<Pet> pets = Arrays.asList(
                new Pet("123", "GAIA", "CAT",  "Small", "Female", 2),
                new Pet("456", "MUNECA", "DOG", "Small", "Female", 12),
                new Pet("789", "Zahir", "DOG", "Large", "Male", 8),
                new Pet("012", "PLANTS", "PLANT", "Small", "Female", 1)
        );

        List<Pet> petsFilteredBySizeAndGender = pets.stream()
                .filter(pet -> (pet.getSpecies().equals("CAT") || pet.getSpecies().equals("DOG")))
                //.filter(pet -> pet.getSize().equals("Small"))
                //.filter(pet -> pet.getGender().equals("Female"))
                .collect(Collectors.toList());

        return  petsFilteredBySizeAndGender;
    }
}