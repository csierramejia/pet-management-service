package pet.management.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Pet {

    private String  id;
    private String name;
    private String species;

}
