import org.jetbrains.kotlin.gradle.tasks.Kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")

}
hilt {
    enableExperimentalClasspathAggregation = true
}
// Configure the kapt task
tasks.withType<Kapt>().configureEach {
    // Set the correct annotation processor options
    kapt {
        arguments {
            arg("dagger.hilt.disableModulesHaveInstallInCheck", "true")
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

android {
    namespace = "com.example.pokedexapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokedexapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

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
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("com.google.dagger:hilt-android-gradle-plugin:2.51")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.material:material-icons-core:1.6.2")
    implementation("androidx.compose.material:material-icons-extended:")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Retrofit for network calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Timber for logging
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Coroutines for asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    // Coroutine Lifecycle Scopes to scope the coroutine ot the lifecycle of view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Coil for loading the image from url
    implementation("io.coil-kt:coil:2.6.0")//can be used with both traditional Android views (like ImageView) and doesn't have any specific dependency on Jetpack Compose.
    implementation("io.coil-kt:coil-compose:2.6.0") // extends the core Coil functionality specifically for use with Jetpack Compose
    //Use both for image loading in a Jetpack Compose project. Use only coil:2.6.0 for traditional Android views.

    //implementation("com.google.accompanist:accompanist-coil:0.15.0")
   // the above accompanist is not req. as its inbuilt in coil v2
    //Dagger - Hilt for dependency injection it requires kapt for kotlin annotation processing
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    // implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03") is now not needed
    // we can directly implement viewmodel aware injection using annotation in new version
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    // both the compiler does the same thing ine uses androidx and other hilt for it
    // prefer hilt one its new
    kapt("com.google.dagger:hilt-compiler:2.51")
    implementation("com.google.dagger:hilt-android:2.51")
    //palette for getting the prominent color form our pokemon for the background of the detail screen
    implementation("androidx.palette:palette-ktx:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}