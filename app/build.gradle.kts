import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.kotlin.plugin.parcelize")
}

android {
    namespace = "com.sopt.kakaobank"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sopt.kakaobank"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", getApiKey("base.url"))
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
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {
    // Google
    implementation(libs.material)

    // Test Dependency
    testImplementation(libs.junit)
    // ("test-espresso", "test-junit")
    androidTestImplementation(libs.bundles.androidx.android.test)

    // AndroidX
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    // ("core-ktx", "constraintlayout", "appcompat", "activity")
    implementation(libs.bundles.androidx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)

    // Third-Party
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.serialization.converter)
    implementation(platform(libs.okhttp3.bom))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation(libs.timber)
    implementation(libs.coil)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlin.coroutines)

    // ViewPager
    implementation(libs.viewPager2)

    // Glide
    implementation(libs.glide)

    // Jetpack navi
    implementation(libs.bundles.jetpack.navi)
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(propertyKey)
}