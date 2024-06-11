package pet.management.controller;

import pet.management.model.Pet;
import pet.management.service.PetService;
import pet.management.exception.ServiceException;
import jakarta.inject.Inject;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @GET
    @Path("/{id}")
    public Pet getPetById(@PathParam("id") String id) {
        try {
            return  petService.findById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @POST
    public void registerPet(Pet pet) {
        petService.registerPet(pet);
    }
}
