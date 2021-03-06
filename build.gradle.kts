import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.4.10"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

group = "com.github.djaler"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

configurations {
    all {
        exclude("org.springframework.boot", "spring-boot-starter-logging")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-core")

    implementation("dev.inmo:tgbotapi:0.29.0")

    implementation("io.ktor:ktor-server-netty:1.4.1")
    implementation("io.ktor:ktor-client-apache:1.4.1")
    implementation("io.ktor:ktor-client-jackson:1.4.1")

    implementation("io.sentry:sentry:1.7.30")

    implementation("org.unix4j:unix4j-command:0.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
