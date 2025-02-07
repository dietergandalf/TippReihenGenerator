plugins {
    id("java")
    id ("maven-publish")
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY") ?: ""}")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "tippreihengenerator"
            version = "1.0"
        }
    }
}
