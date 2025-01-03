plugins {
    `java-library`
    `maven-publish`
}

group = "cc.mewcraft"
version = "1.21.3-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "nyaadanbou"
        url = uri("https://repo.mewcraft.cc/releases/")
    }
}

dependencies {
    // required in runtime
    api("cc.mewcraft", "shadow-bukkit", "1.21.3-SNAPSHOT")
    // already included in server
    compileOnly("org.checkerframework:checker-qual:3.44.0")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    repositories {
        maven {
            name = "nyaadanbou"
            url = uri("https://repo.mewcraft.cc/releases/")
            credentials {
                username = providers.gradleProperty("nyaadanbou.mavenUsername").orNull
                password = providers.gradleProperty("nyaadanbou.mavenPassword").orNull
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

java {
    withSourcesJar()
}

java.toolchain {
    languageVersion = JavaLanguageVersion.of(21)
}

tasks.test {
    useJUnitPlatform()
}

