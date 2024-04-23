package pet.management.controller;

import pet.management.model.Pet;
import pet.management.service.PetService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PetController {

    @Inject
    private PetService petService;

    @GET
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @POST
    public void registerPet(Pet pet) {
        petService.registerPet(pet);
    }
}
