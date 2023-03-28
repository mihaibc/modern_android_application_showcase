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
rootProject.name = "TheMoviesCorner"
include(":app")

include(":ui")
include(":domain")
include(":data")
include(":core")
include(":core:util")
include(":core:common")
