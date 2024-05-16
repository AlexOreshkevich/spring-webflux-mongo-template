![example branch parameter](https://github.com/AlexOreshkevich/spring-webflux-mongo-template/actions/workflows/gradle.yml/badge.svg?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=AlexOreshkevich_spring-webflux-mongo-template&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=AlexOreshkevich_spring-webflux-mongo-template)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=AlexOreshkevich_spring-webflux-mongo-template&metric=bugs)](https://sonarcloud.io/summary/new_code?id=AlexOreshkevich_spring-webflux-mongo-template)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=AlexOreshkevich_spring-webflux-mongo-template&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=AlexOreshkevich_spring-webflux-mongo-template)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=AlexOreshkevich_spring-webflux-mongo-template&metric=coverage)](https://sonarcloud.io/summary/new_code?id=AlexOreshkevich_spring-webflux-mongo-template)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=AlexOreshkevich_spring-webflux-mongo-template&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=AlexOreshkevich_spring-webflux-mongo-template)
# spring-webflux-mongo-template

Template project for Spring Boot and MongoDB with Reactive REST API (WebFlux)

## Improvements

### Build configuration
- Gradle parallel build turned on (`gradle.properties`)
- YAML configurations for `main` and `test`
- Configured `Develocity Gradle plugin` (Gradle Build Scans)
- Parallel test execution configured for JUnit 5

### DAO layer enhancements
- [Class-based Projections (DTOs)](https://docs.spring.io/spring-data/mongodb/reference/repositories/projections.html#projections.dtos) (Repositories returns DTO classes with reduced number of fields, using `projection` database feature, no explicit Entity - DTO mapping!)

### Testing
- [Test Pyramid](https://martinfowler.com/articles/practical-test-pyramid.html) with explicit
separation of component, integration and functional tests
- [Reusable containers](https://java.testcontainers.org/features/reuse/) (given in `IntegrationTest`)
- Test container database initialization script (`init-schema.js`)
- The standard streams (err and out) made visible at console when running tests

### Plugins
- Dependency on Lombok replaced
with [Lombok Gradle Plugin](https://plugins.gradle.org/plugin/io.freefair.lombok)
- `io.spring.dependency-management` plugin replaced with Gradle `platform` plugin
- `spotless` configured for Google Code Style for Java (https://github.com/diffplug/spotless/tree/main/plugin-gradle#java)

## Access Swagger
Navigate to http://localhost:8080/swagger-ui.html
