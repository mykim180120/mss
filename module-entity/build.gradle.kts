val generatedSourcesDir = "src/main/generated"

sourceSets {
    getByName("main") {
        java.srcDirs(generatedSourcesDir)
    }
}

tasks.named<JavaCompile>("compileJava") {
    options.generatedSourceOutputDirectory.set(file(generatedSourcesDir))
}

tasks.named<Delete>("clean") {
    doLast {
        file(generatedSourcesDir).deleteRecursively()
    }
}

dependencies {
    implementation(project(":module-common"))

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation("org.projectlombok:lombok")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.apache.commons:commons-lang3")

    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
    testImplementation("org.projectlombok:lombok")

    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.bootJar {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = true
    dependsOn("test")
}
