plugins {
    kotlin("js") version "1.5.10"
    id("org.ajoberstar.git-publish") version "3.0.0"
    id("org.ajoberstar.grgit") version "4.1.0"
}

group = "eu.koders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://ajoberstar.github.io/bintray-backup/")
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        useCommonJs()
        binaries.executable()

        sourceSets["main"].dependencies {
            val reactVersion = "17.0.2"
            val reactRouterVersion = "5.2.0"
            val styledVersion = "5.3.0"
            val kotlinWrapperVersion = "pre.213-kotlin-1.5.10"

            implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$reactVersion-$kotlinWrapperVersion")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$reactVersion-$kotlinWrapperVersion")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$reactRouterVersion-$kotlinWrapperVersion")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$styledVersion-$kotlinWrapperVersion")
        }
    }
}

val auth = (project.findProperty("com.github.http.auth") as? String)?.split(":")
if (auth != null) {
    System.setProperty("org.ajoberstar.grgit.auth.username", auth[0])
    System.setProperty("org.ajoberstar.grgit.auth.password", auth[1])
}

gitPublish {
    repoUri.set("https://github.com/KodeinKoders/kotlin-koders.eu.git")
    branch.set("gh-pages")
    contents.apply {
        from("$projectDir/build/distributions")
    }
    val head = grgit.head()
    commitMessage.set("${head.abbreviatedId}: ${head.fullMessage}")
}

task("deployWebsiteToGithubPages") {
    group = "publishing"
    dependsOn("gitPublishPush")
}

tasks["gitPublishCopy"].dependsOn("browserDistribution")

tasks["gitPublishCommit"].doFirst {
    if (!grgit.status().isClean) {
        error("Refusing to commit new pages on a non-clean repo. Please commit first.\n${grgit.status()}")
    }
}