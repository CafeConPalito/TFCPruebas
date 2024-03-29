plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.cafeconpalito.pruebas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cafeconpalito.pruebas"
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

    viewBinding{
        enable= true
    }

    /*
    Version antigua de llamar a los View Bindings
    buildFeatures{
        viewBinding= true
    }
    */

}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1") //
    implementation("androidx.appcompat:appcompat:1.6.1") //
    implementation("com.google.android.material:material:1.11.0") //
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") //
    implementation("androidx.activity:activity:1.8.2") //

    //Picasso para descargar imagenes
    implementation("com.squareup.picasso:picasso:2.71828")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0") //

    //Para Retrofit - Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") //
    implementation("com.google.code.gson:gson:2.10.1") //

    //Para Retrofit - Jackson
    //implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    //implementation("com.fasterxml.jackson.core:jackson-core:2.16.1")
    //implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    //implementation("com.fasterxml.jackson.core:jackson-annotations:2.16.1")

    //Para implementar fragmentos
    implementation("androidx.fragment:fragment-ktx:1.6.2") //

    //Implementa MVVM (Modelo-Vista-ViewModel)
    //Necesario para implementar los ViewModel y poder atacar a la api con Corrutinas
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //navigation Fragments
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")







}