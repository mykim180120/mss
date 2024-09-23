buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version ("3.2.9")
    id("io.spring.dependency-management") version ("1.1.6")
    id("com.diffplug.spotless") version "6.19.0"
    id("io.freefair.lombok") version "8.0.1"
    id("jacoco")
    java
}

spotless {
    val excludeFiles = arrayOf(".idea/**/*.*", ".vscode/**/*.*")

    java {
        targetExclude("build/**/*.java")
        removeUnusedImports()
        replaceRegex("Remove wildcard imports", "import\\s+[^\\*\\s]+\\*;(\\r\\n|\\r|\\n)", "$1")
        googleJavaFormat()
        importOrder(
            "java",
            "jakarta",
            "javax",
            "lombok",
            "org.springframework",
            "",
            "org.junit",
            "com.mss",
            "\\#",
            "\\#org.junit",
            "\\#com.mss",
        )
        indentWithTabs(2)
        indentWithSpaces(4)
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("yaml") {
        target("**/*.yaml", "**/*.yml")
        targetExclude(*excludeFiles)
        prettier().configFile(".prettierrc")
    }
    format("xml") {
        target("**/*.xml")
        targetExclude(*excludeFiles)
        prettier().config(mapOf("parser" to "html", "printWidth" to 160)).configFile(".prettierrc")
    }
    format("md") {
        target("**/*.md")
        targetExclude(*excludeFiles)
        prettier().config(mapOf("printWidth" to 160)).configFile(".prettierrc")
    }
}

allprojects {
    plugins.apply {
        apply("java")
        apply("java-library")
        apply("maven-publish")
        apply("eclipse")
        apply("idea")
        apply("org.springframework.boot")
        apply("io.spring.dependency-management")
    }

    group = "com.mss.fashion"
    version = "1.0.0"
    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    if (configurations.findByName("compileOnly") == null) {
        configurations.create("compileOnly") {
            extendsFrom(configurations["annotationProcessor"])
        }
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    tasks.register("initSourceFolders") {
        val javaSourceDirs = sourceSets.flatMap { it.java.srcDirs }
        val resourcesDirs = sourceSets.flatMap { it.resources.srcDirs }

        javaSourceDirs.forEach { dir ->
            if (!dir.exists()) {
                dir.mkdirs()
            }
        }

        resourcesDirs.forEach { dir ->
            if (!dir.exists()) {
                dir.mkdirs()
            }
        }
    }
}

tasks.bootJar {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.jacocoTestReport {
    reports {
        html.required.set(true)
        xml.required.set(false)
        csv.required.set(false)
    }
}

tasks.jacocoTestCoverageVerification {
    val queryDslClasses = ('A'..'Z').map { "*.Q${it}*" };
    violationRules {
        rule {
            element = "CLASS"
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.70".toBigDecimal()
            }
            excludes = listOf(
                "com.mss.fashion.Application"
            ) + queryDslClasses
        }
    }
}

val testCoverage by tasks.registering {
    group = "verification"
    description = "Runs the unit tests with coverage"
    dependsOn(":test", ":jacocoTestReport", ":jacocoTestCoverageVerification")
    tasks["jacocoTestReport"].mustRunAfter(tasks["test"])
    tasks["jacocoTestCoverageVerification"].mustRunAfter(tasks["jacocoTestReport"])
}

val testAll by tasks.registering {
    group = "verification"
    description = "Runs all tests"
    dependsOn(":spotlessCheck", ":test", ":jacocoTestReport", ":jacocoTestCoverageVerification")
    tasks["test"].mustRunAfter(tasks["spotlessCheck"])
    tasks["jacocoTestReport"].mustRunAfter(tasks["test"])
    tasks["jacocoTestCoverageVerification"].mustRunAfter(tasks["jacocoTestReport"])
}
