plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.salir.notic"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.salir.notic"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
            project.extensions.extraProperties["android.enableAppCompileTimeRClass"] = true
        }

        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }

        flavorDimensions += "version"

        productFlavors {
            create("dev") {
                dimension = "version"
                versionNameSuffix = "-dev"
            }
            create("prod") {
                dimension = "version"
                versionNameSuffix = "-release"
            }
        }

    }
    compileOptions {
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.animation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)
    androidTestImplementation(platform(libs.compose.bom))
}