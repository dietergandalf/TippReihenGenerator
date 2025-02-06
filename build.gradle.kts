plugins {
    id("java")
}

group = "org.generator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.10.0")

}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "org.generator.Main"
        )
    }
}

tasks.test {
    useJUnitPlatform()
}