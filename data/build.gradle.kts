plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    js(IR) {
        browser()
    }
}
