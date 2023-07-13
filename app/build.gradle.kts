@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "tech.foxio.examplemvi"
    compileSdk = 33

    defaultConfig {
        applicationId = "tech.foxio.examplemvi"
        minSdk = 24
        targetSdk = 33
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation(project(":n2n"))
    //==================== Logging =================================
    val logVersion = "2.6.9"
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:core:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:file:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:okhttp:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:fastjson:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:gson:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:debug_view:$logVersion")
    implementation("com.github.fengzhizi715.SAF-Kotlin-log:extension:$logVersion")

    //==================== Networking =============================
    val retrofitVersion = "2.9.0"
    val okhttpVersion = "4.11.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    //==================== Dependency Injection ==================
    val hiltVersion = "2.46.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //==================== Database ==============================
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    //==================== Datastore ==============================
    implementation("androidx.datastore:datastore-preferences-core:1.0.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //==================== Navigation ===============================
    implementation("androidx.navigation:navigation-compose:2.6.0")

    //==================== Memory Leak Detection ====================
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.12")

    //==================== Image Loading ============================
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}