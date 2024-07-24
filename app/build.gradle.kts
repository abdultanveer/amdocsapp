plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }

    namespace = "com.example.amdocsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.amdocsapp"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.retrofit)
    implementation(libs.converter.scalars)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)
    implementation(libs.coil)
    //dagger dependencies
    annotationProcessor(libs.dagger.compiler)
    annotationProcessor(libs.dagger.android.processor)
    implementation(libs.dagger.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

  /*  implementation ("com.google.dagger:dagger-android:2.38.1")
    //  implementation ("'com.google.dagger:dagger-android-support:2.38.1")// if you use the support libraries
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.38.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.38.1")*/

}