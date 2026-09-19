plugins {
    kotlin("jvm") version "2.2.21"
}

group = "app.tkiethuynh.denpatch"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    compileOnly("app.morphe:morphe-patcher:1.5.1")
    compileOnly("com.github.MorpheApp.smali:smali:b6365a84f4")
}

sourceSets {
    main {
        java.srcDirs("patches/src/main/kotlin")
        resources.srcDirs("patches/src/main/resources")
    }
}

tasks.jar {
    archiveBaseName.set("den-patch")
    manifest.attributes(
        "Implementation-Title" to "Den Patches",
        "Implementation-Version" to project.version,
        "Main-Class" to "",
        "Author" to "Kiet Huynh",
        "Source" to "https://github.com/tkiethuynh/den-patch",
        "License" to "GNU General Public License v3.0",
        "Patcher-Version" to "1.5.1"
    )
}

kotlin {
    compilerOptions.freeCompilerArgs.add("-Xcontext-parameters")
}
