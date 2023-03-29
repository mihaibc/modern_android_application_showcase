pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "tmc"
include(":app")

include(":ui")
include(":domain")
include(":data")
include(":core")
include(":core:util")
include(":core:common")
include(":data:network")
