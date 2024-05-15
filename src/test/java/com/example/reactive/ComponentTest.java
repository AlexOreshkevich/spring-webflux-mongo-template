package com.example.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ComponentTest extends IntegrationTest {

    @Autowired
    ApplicationContext context;

    @Test
    void shouldLoadSpringContext() {
        assertThat(context).isNotNull();
        assertThat(MONGO_DB_CONTAINER.isRunning()).isTrue();
        assertThat(context.getBean(ReactiveMongoTemplate.class)).isNotNull();
    }
}