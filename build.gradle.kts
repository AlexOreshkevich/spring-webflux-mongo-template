plugins {
  java
  id("io.freefair.lombok") version "8.6"
  id("org.springframework.boot") version "3.2.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  // Spring Boot 3.X
  implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.5"))

  // Infra
  implementation("org.springframework.boot:spring-boot-starter-actuator")

  // Reactive REST API
  implementation("org.springframework.boot:spring-boot-starter-webflux")

  // Reactive MongoDB
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

  // Testing
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-testcontainers")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("org.testcontainers:mongodb")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
  systemProperty("junit.jupiter.execution.parallel.enabled", true)
  systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
  systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
}

// https://docs.gradle.org/current/userguide/performance.html#execute_tests_in_parallel
tasks.withType<Test>().configureEach {
  maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
  reports.html.required = false
  reports.junitXml.required = false
}

develocity {
  buildScan {
    termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
    termsOfUseAgree.set("yes")
    // Adjust according to your CI server:
    // https://docs.gradle.com/develocity/gradle-plugin/current/#configuring_background_uploading
    uploadInBackground.set(false)
  }
}