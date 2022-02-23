plugins {
    id(PluginIds.application)
    id(PluginIds.kotlinAndroid)
    id(PluginIds.kotlinKapt)
}

apply{
    plugin(PluginIds.navigationSafeArgs)
}


android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.reza.githubapp"

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }

    lint {
        abortOnError = false
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(ProjectModules.domain))
    implementation(project(ProjectModules.data))
    implementation(project(ProjectModules.remote))
    implementation(project(ProjectModules.local))

    implementation(Dependencies.AndroidX.fragmentKtx)
    kapt(Dependencies.AndroidX.lifecycleCompiler)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    implementation(Dependencies.AndroidX.lifecycleViewModel)

    implementation(Dependencies.kotlinxCoroutines)
    implementation(Dependencies.timber)
    implementation(Dependencies.dataMapper)
    kapt(Dependencies.dataMapperCompiler)
    implementation(Dependencies.Koin.koinCore)
    implementation(Dependencies.Koin.koinAndroid)

    implementation(Dependencies.glide)
    implementation(Dependencies.lottie)
    implementation(Dependencies.viewBindingDelegate)
    implementation(Dependencies.internetCheckerDialog)

    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.MaterialDialog.materialDialogCore)
    implementation(Dependencies.MaterialDialog.materialDialogLifecycle)
    implementation(Dependencies.MaterialDialog.materialDialogInput)
    implementation(Dependencies.MaterialDialog.materialDialogBottomSheet)
    implementation(Dependencies.AndroidX.legacySupport)
    implementation(Dependencies.AndroidX.Navigation.fragmentKtx)
    implementation(Dependencies.AndroidX.Navigation.uiKtx)
    implementation(TestDependencies.stetho)
    implementation(TestDependencies.stethoOKHttp)

    androidTestImplementation(TestDependencies.AndroidX.core)
    androidTestImplementation(TestDependencies.AndroidX.coreKtx)
    androidTestImplementation(TestDependencies.AndroidX.runner)
    androidTestImplementation(TestDependencies.AndroidX.rules)
    androidTestImplementation(TestDependencies.AndroidX.espressoCore)
    androidTestImplementation(TestDependencies.AndroidX.espressoContrib)
    androidTestImplementation(TestDependencies.AndroidX.junit)
    androidTestImplementation(TestDependencies.kotlinxCoroutines)
    androidTestImplementation(TestDependencies.mockWebServer)
}
