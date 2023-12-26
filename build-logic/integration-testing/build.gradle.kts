plugins {
    id("gradlebuild.build-logic.kotlin-dsl-gradle-plugin")
}

description = "Provides plugins to create and configure integration, cross-version and distribution tests"

gradlePlugin {
    plugins {
        register("androidStudioProvisioning") {
            id = "gradlebuild.android-studio-provisioning"
            implementationClass = "gradlebuild.integrationtests.ide.AndroidStudioProvisioningPlugin"
        }
    }
    plugins {
        register("smokeIdeTesting") {
            id = "gradlebuild.smoke-ide-testing"
            implementationClass = "gradlebuild.integrationtests.ide.SmokeIdeTestPlugin"
        }
    }
}

dependencies {
    implementation("gradlebuild:basics")
    implementation("gradlebuild:module-identity")

    implementation(project(":cleanup"))
    implementation(project(":dependency-modules"))

    testImplementation("junit:junit")
}
