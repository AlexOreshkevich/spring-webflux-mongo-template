package com.example.reactive;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

@Testcontainers
@Execution(ExecutionMode.SAME_THREAD)
public abstract class IntegrationTest {

    // Eliminates the need of @DynamicPropertySource
    @ServiceConnection
    protected static MongoDBContainer MONGO_DB_CONTAINER = new MongoDBContainer(
            DockerImageName.parse("mongo:7.0.8")
    )
            .withReuse(true)
            // Copies an initialization file called init-schema.js into the container.
            // This file contains a script for database initialization
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("./init-schema.js"),
                    "/docker-entrypoint-initdb.d/init-schema.js"
            );

    static {
        MONGO_DB_CONTAINER.start();
    }
}