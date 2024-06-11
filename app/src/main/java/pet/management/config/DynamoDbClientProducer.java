package pet.management.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@ApplicationScoped
public class DynamoDbClientProducer {

    @Produces
    @Singleton
    public DynamoDbClient createDynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_1) // Reemplaza por tu región
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}