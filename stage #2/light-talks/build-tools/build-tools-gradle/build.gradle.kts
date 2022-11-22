plugins {
    id("java")
}

group = "school.epam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repository.jboss.org/maven2")
    }
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

task<Task>("customTask") {
    description = "My custom task"
    group = "custom"

    afterEvaluate {
        for (i in 1..10) {
            println("Hello World")
        }
    }
}

tasks.getByName<JavaCompile>("compileJava") {
    dependsOn("customTask")
}

task<Copy>("copyFooBar") {
    from(file("foo.bar"))
    into(file("src/main/resources"))
}
