group = "app.tkiethuynh.denpatch"

patches {
    about {
        name = "Den Patches"
        description = "Morphe patches for Imou Life."
        source = "https://github.com/tkiethuynh/den-patch"
        author = "Kiet Huynh"
        contact = "https://github.com/tkiethuynh"
        website = "https://github.com/tkiethuynh/den-patch"
        license = "GPLv3"
    }
}

// Separate configuration so gson is available at runtime for the
// generatePatchesList task but never bundled into the APK.
val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    // Used by gradle-semantic-release-plugin.
    publish {
        dependsOn("generatePatchesList")
    }
}
