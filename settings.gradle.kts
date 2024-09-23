pluginManagement {
    repositories {
        mavenCentral()
        maven("https://repo.spring.io/milestone")
        maven("https://repo.spring.io/snapshot")
        gradlePluginPortal()
    }
}
rootProject.name = "mss"
include("module-common")
include("module-entity")
include("mss-admin")
include("mss-coordi")
