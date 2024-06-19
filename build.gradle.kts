plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
//    testImplementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
//    implementation("com.github.cliftonlabs:json-simple:4.0.1")
}

tasks.test {
    useJUnitPlatform()
}