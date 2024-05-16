package com.example.reactive;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

@Testcontainers
@Execution(ExecutionMode.SAME_THREAD)
public abstract class IntegrationTest {

  protected static GenericContainer<?> MONGO_DB_CONTAINER =
      new GenericContainer<>(DockerImageName.parse("mongo:7.0.8"))
          .withExposedPorts(27017)
          // Copies an initialization file called init-schema.js into the container.
          // This file contains a script for database initialization
          .withCopyFileToContainer(
              MountableFile.forClasspathResource("./init-schema.js"),
              "/docker-entrypoint-initdb.d/init-schema.js")
          .withReuse(true);

  static {
    MONGO_DB_CONTAINER.start();
  }

  // We can't use @ServiceConnection in here because we've chosen init script feature
  // which is not working on CI/CD with MongoContainer cause it's replica set by default
  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.host", MONGO_DB_CONTAINER::getHost);
    registry.add("spring.data.mongodb.port", MONGO_DB_CONTAINER::getFirstMappedPort);
  }
}
