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
- Correct example of using `@ServiceConnection` and reusable containers (given in `IntegrationTest`)
- Test database initialization script (`init-schema.js`)

### Plugins
- Dependency on Lombok replaced
  with [Lombok Gradle Plugin](https://plugins.gradle.org/plugin/io.freefair.lombok)
- `io.spring.dependency-management` plugin replaced with Gradle `platform` plugin