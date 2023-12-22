import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = false
bootJar.enabled = false

plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = "com.elroykanye"
    version = "0.0.1-SNAPSHOT"

    apply { plugin("java") }

    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    dependencies {
        implementation(platform(SpringBootPlugin.BOM_COORDINATES))
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.kafka:spring-kafka")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.kafka:spring-kafka-test")

        compileOnly("org.projectlombok:lombok:1.18.26")
        annotationProcessor("org.projectlombok:lombok:1.18.26")

        testCompileOnly("org.projectlombok:lombok:1.18.26")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.26")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
