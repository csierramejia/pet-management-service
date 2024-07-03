import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.*;
import jakarta.inject.Inject;
import java.util.List;

import pet.management.model.Pet;
import pet.management.service.PetService;

@GraphQLApi
public class PetControllerGraphQL {

    @Inject
    private PetService petService;

    @Query("allPets")
    public List<Pet> getAllPets() {
        return  petService.findPets();
    }
}