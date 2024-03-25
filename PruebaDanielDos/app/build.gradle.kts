plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    //DaggerHilt
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    //Es lo mismo
    //id("com.google.devtools.ksp")version "1.9.10-1.0.13"
    //id("com.google.dagger.hilt.android")version "2.50"
}

android {
    namespace = "com.cafeconpalito.pruebadanieldos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cafeconpalito.pruebadanieldos"
        minSdk = 27
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

    //Para activar el View Binding
    viewBinding{
        enable=true
    }
}

dependencies {

    val navVersion = "2.7.7"

    //navigation Fragments
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //DaggerHilt
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    //Es lo mismo
    //implementation("com.google.dagger:hilt-android:2.50")
    //ksp("com.google.dagger:hilt-android-compiler:2.50")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}