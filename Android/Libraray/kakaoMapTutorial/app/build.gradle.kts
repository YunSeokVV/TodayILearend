import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// local.properties 파일을 불러옵니다.
val properties = Properties()
properties.load(FileInputStream(rootProject.file("local.properties")))

// 불러온 값에서 API 키를 가져옵니다.
val kakaoMapApiKey: String = properties.getProperty("KAKAO_API_KEY")

android {
    namespace = "com.example.kakaomaptutorial"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kakaomaptutorial"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "KAKAO_MAP_API_KEY", "\"$kakaoMapApiKey\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }

}

dependencies {
    implementation(libs.orhanobut)
    implementation(libs.kakao.maps)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}