package pet.management.model.builder;

import pet.management.model.Pet;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.Map;

public class PetBuilder {

    public static Pet fromMap(Map<String, AttributeValue> item) {

        return Pet.builder()
                .id(item.get("id").s())
                .name(item.get("name").s())
                .species(item.get("species").s())
                .build();
    }

}
