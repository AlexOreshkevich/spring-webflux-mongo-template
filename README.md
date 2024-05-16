[![codecov](https://codecov.io/gh/AlexOreshkevich/spring-webflux-mongo-template/graph/badge.svg?token=WfdvociCUK)](https://codecov.io/gh/AlexOreshkevich/spring-webflux-mongo-template)
# spring-webflux-mongo-template

Template project for Spring Boot and MongoDB with Reactive REST API (WebFlux)

## Improvements

### Build configuration
- Gradle parallel build turned on (`gradle.properties`)
- YAML configurations for `main` and `test`
- Configured `Develocity Gradle plugin` (Gradle Build Scans)
- Parallel test execution configured for JUnit 5

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
