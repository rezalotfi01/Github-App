object ProjectModules {
    const val app = ":app"
    const val domain = ":domain"
    const val data = ":data"
    const val remote = ":remote"
    const val local = ":local"
}

object Versions {
    const val core = "1.7.0"
    const val fragment = "1.4.0"
    const val navigation = "2.3.5"
    const val constraintLayout = "2.1.0"
    const val materialDialog = "3.3.0"
    const val legacySupport = "1.0.0"
    const val lifecycle = "2.4.0"
    const val paging = "3.1.0"
    const val koin = "3.1.5"
    const val androidxTest = "1.3.0"
    const val espresso = "3.4.0"
    const val androidxJunit = "1.1.2"
    const val junit = "4.12"
    const val junitPlatformRunner = "1.0.2"
    const val mockito = "3.12.3"
    const val mockitoKotlin = "1.6.0"
    const val stetho = "1.5.1"
    const val gradle = "7.0.4"
    const val kotlin = "1.6.10"
    const val timber = "5.0.1"
    const val dataMapper = "1.4.2.Final"
    const val lottie = "4.2.2"
    const val retrofit = "2.9.0"
    const val room = "2.3.0"
    const val okhttp = "4.9.3"
    const val glide = "4.12.0"
    const val viewBindingDelegate = "1.4.7"
    const val kotlinxCoroutines = "1.6.0"
    const val internetCheckerDialog = "2.0.0"
}

object BuildDependencies {
    const val androidGradle =
        "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object PluginIds{

    const val application = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val gradlePlugin = "com.reza.android.plugin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlin = "kotlin"
    const val kotlinKapt = "kotlin-kapt"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
}

object Dependencies {

    object AndroidX {
        const val fragmentKtx =
            "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val coreKtx =
            "androidx.core:core-ktx:${Versions.core}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val legacySupport =
            "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecycleLivedataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val lifecycleCompiler =
            "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val pagingRuntime =
            "androidx.paging:paging-runtime-ktx:${Versions.paging}"
        const val paging =
            "androidx.paging:paging-common-ktx:${Versions.paging}"

        object Navigation {
            const val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val uiKtx =
                "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Koin {
        const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
        const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
        const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    }

    object MaterialDialog {
        const val materialDialogCore = "com.afollestad.material-dialogs:core:${Versions.materialDialog}"
        const val materialDialogLifecycle = "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialog}"
        const val materialDialogInput = "com.afollestad.material-dialogs:input:${Versions.materialDialog}"
        const val materialDialogBottomSheet = "com.afollestad.material-dialogs:bottomsheets:${Versions.materialDialog}"
    }

    object Retrofit{
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverterGson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    const val kotlinxCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"

    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val dataMapper = "org.mapstruct:mapstruct:${Versions.dataMapper}"
    const val dataMapperCompiler = "org.mapstruct:mapstruct-processor:${Versions.dataMapper}"

    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val viewBindingDelegate =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingDelegate}"

    const val internetCheckerDialog =
        "org.imaginativeworld.oopsnointernet:oopsnointernet:${Versions.internetCheckerDialog}"
}

object TestDependencies {

    object AndroidX {
        const val core =
            "androidx.test:core:${Versions.androidxTest}"
        const val coreKtx =
            "androidx.test:core-ktx:${Versions.androidxTest}"

        const val runner =
            "androidx.test:runner:${Versions.androidxTest}"
        const val rules =
            "androidx.test:rules:${Versions.androidxTest}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val espressoContrib =
            "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
        const val junit =
            "androidx.test.ext:junit:${Versions.androidxJunit}"
    }

    const val kotlinxCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutines}"

    object JUnit {
        const val junit =
            "junit:junit:${Versions.junit}"
        const val junitPlatformRunner =
            "org.junit.platform:junit-platform-runner:${Versions.junitPlatformRunner}"
    }

    object Mockito {
        const val mockitoCore =
            "org.mockito:mockito-core:${Versions.mockito}"
        const val mockitoInline =
            "org.mockito:mockito-inline:${Versions.mockito}"
        const val mockitoKotlin =
            "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    }

    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"

    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoOKHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

}
