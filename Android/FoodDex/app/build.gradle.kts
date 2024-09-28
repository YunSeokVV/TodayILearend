plugins {
    //alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.android.application")
    id("com.google.dagger.hilt.android")

    //id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.fooddex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fooddex"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    dataBinding {
        true
    }
    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    //annotationProcessor 'com.google.dagger:hilt-compiler:2.52'
    implementation("com.google.dagger:hilt-android:2.52")
    implementation("com.github.skydoves:sandwich:2.0.9")
    implementation("com.github.skydoves:sandwich-retrofit:2.0.9") // For Retrofit (Android)
    kapt("com.google.dagger:hilt-compiler:2.52")
    implementation("com.orhanobut:logger:2.2.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // by viewModels 를 사용하기 위해 추가한 라이브러리
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.activity:activity-ktx:1.5.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}