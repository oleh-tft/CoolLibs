plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ua.tft.coollibs"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "ua.tft.coollibs"
        minSdk = 33
        targetSdk = 36
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
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)

    // 1. Glide (Зображення)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // 2. KenBurnsView (Анімація фону)
    implementation("com.flaviofaria:kenburnsview:1.0.7")
    // 3. Shimmer (Ефект завантаження)
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    // 4. TapTargetView (Онбординг/Підказки)
    implementation("com.getkeepsafe.taptargetview:taptargetview:1.13.3")
    // 5. Konfetti (Частинки/Ефекти свята)
    implementation("nl.dionsegijn:konfetti-xml:2.0.4")
}