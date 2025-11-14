plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.gk.bricks"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gk.bricks"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }

        ndk {
            abiFilters += listOf("arm64-v8a")
        }

        packaging {
            resources {
                excludes += listOf("linux-aarch64/libdiozero-system-utils.so")
            }
        }

    }


    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName = "${variant.buildType.name}_v${variant.versionName}.apk"
                println("OutputFileName: $outputFileName")
                output.outputFileName = outputFileName
            }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BUILD_VARIANT", "\"prod\"")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BUILD_VARIANT", "\"debug\"")
        }

        create("development") { //Development for developer
            isDebuggable = true
            buildConfigField("String", "BUILD_VARIANT", "\"debug\"")
            isProfileable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
        create("staging") {
            buildConfigField("String", "BUILD_VARIANT", "\"staging\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        create("roadShow") {
            buildConfigField("String", "BUILD_VARIANT", "\"roadShow\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }

        create("production") {
            buildConfigField("String", "BUILD_VARIANT", "\"prod\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
//        compose = true
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.hilt.work)
    implementation(libs.ads.mobile.sdk)
    implementation("androidx.security:security-crypto-ktx:1.1.0-alpha06")
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.ui)


    //Scalable size units
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    //Permissions requests and handler
    implementation(libs.dexter)

    //Dagger Hilt -Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.firebase.storage)
    implementation(libs.firebase.database)

    implementation(libs.lottie)

    //Parse Server
    implementation (libs.parse)
    implementation("com.github.parse-community:ParseLiveQuery-Android:1.2.2")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.1") // Or latest

    implementation("org.nanohttpd:nanohttpd:2.3.1")

    implementation("de.hdodenhof:circleimageview:3.1.0")

    //AWS
    implementation("com.amazonaws:aws-android-sdk-s3:2.78.0")

    // image cropper (recommended)
    implementation("com.vanniktech:android-image-cropper:4.6.0")

    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    implementation("com.github.chrisbanes:PhotoView:2.3.0")


}