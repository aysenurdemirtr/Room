 plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Kapt eklentisi burada tanımlanıyor
    id("androidx.navigation.safeargs") version "2.7.0" // Safe Args eklentisi
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.room"
    compileSdk = 34

    kapt {
        correctErrorTypes = true
    }


    defaultConfig {
        applicationId = "com.example.room"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.1"

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
        sourceCompatibility = org.gradle.api.JavaVersion.VERSION_17
        targetCompatibility = org.gradle.api.JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.5")

    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // Room components
    implementation("androidx.room:room-runtime:2.6.0") // Room runtime
    kapt("androidx.room:room-compiler:2.6.0") // Room compiler
    implementation("androidx.room:room-ktx:2.6.0") // Room KTX for Kotlin support

    // Optional: Room testing
    androidTestImplementation("androidx.room:room-testing:2.6.0") // For testing Room

    // Optional: Coroutines support
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0") // Coroutines for asynchronous operations
}

