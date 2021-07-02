plugins {
    kotlin("js") version "1.5.10"
}

group = "eu.koders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
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