plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.compose"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    buildToolsVersion = "35.0.0"
    ndkVersion = "27.1.12297006"
}

dependencies {

    // Compose BOM for consistent versioning
    implementation(platform(libs.androidx.compose.bom))

    // Compose UI essentials
    implementation(libs.bundles.compose.ui)

    // Material Design 3 and icons
    implementation(libs.bundles.material.design)

    // Activity and Lifecycle integration
    implementation(libs.bundles.activity.lifecycle)

    // Core Android dependencies
    implementation(libs.bundles.core.android)

    // Test dependencies
    testImplementation(libs.bundles.testing)

    // Android-specific UI testing dependencies
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.bundles.testing)
}