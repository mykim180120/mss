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

    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.9"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation("com.google.code.gson:gson")
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    runtimeOnly("net.logstash.logback:logstash-logback-encoder:7.2")
    runtimeOnly("com.h2database:h2")

    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("org.projectlombok:lombok")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.squareup.okhttp3:okhttp:4.12.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testImplementation("org.mockito:mockito-inline:4.9.0")
    testImplementation("com.github.fppt:jedis-mock:1.0.5")
}

tasks.bootJar {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = true
    dependsOn("test")
}
