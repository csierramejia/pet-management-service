package pet.management.repository;

import pet.management.model.Pet;
import pet.management.model.builder.PetBuilder;
import pet.management.exception.RepositoryException;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

@ApplicationScoped
public class PetRepositoryImpl implements PetRepository{

    private static final Logger LOGGER = Logger.getLogger(PetRepositoryImpl.class);

    @Inject
    DynamoDbClient ddb;

    @Override
    public Pet findById(String id) {

        try {

            Map<String, AttributeValue> key = new HashMap<>();
            key.put("id", AttributeValue.builder().s(id).build());
            GetItemRequest request = GetItemRequest.builder()
                    .tableName("pets")
                    .key(key)
                    .build();

            GetItemResponse response = ddb.getItem(request);
            Map<String, AttributeValue> item = response.item();
            if (item != null) {
                item.forEach((key1, value) -> System.out.println(key1 + ": " + value.s())); // Suponiendo que todos los valores son cadenas
                return PetBuilder.fromMap(item);
            }

        } catch (Exception e) {
            LOGGER.error("Error fetching item from DynamoDB", e);
            throw new RepositoryException("Error fetching item from DynamoDB", e);
        }

        return null;
    }

    @Override
    public List<Pet> getAllPets() {

        List<Pet> pets = new ArrayList<>();

        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName("pets")
                    .build();

            ScanResponse scanResponse = ddb.scan(scanRequest);
            List<Map<String, AttributeValue>> items = scanResponse.items();

            for (Map<String, AttributeValue> item : items) {
                pets.add(PetBuilder.fromMap(item));
            }

        } catch (Exception e) {
            LOGGER.error("Error fetching item from DynamoDB", e);
            e.printStackTrace();
        }

        return pets;
    }

    @Override
    public void savePet(Pet pet) {

    }

}