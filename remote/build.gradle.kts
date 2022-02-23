plugins {
    id(PluginIds.kotlinAndroid)
    id(PluginIds.androidLibrary)
    id(PluginIds.kotlinKapt)
}

android{
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}

dependencies {
    implementation(project(ProjectModules.data))
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))

    api(Dependencies.Retrofit.retrofit)
    api(Dependencies.Retrofit.retrofitConverterGson)
    api(Dependencies.okHttpLoggingInterceptor)

    implementation(Dependencies.kotlinxCoroutines)
    implementation(Dependencies.timber)
    implementation(Dependencies.dataMapper)
    kapt(Dependencies.dataMapperCompiler)
    implementation(Dependencies.Koin.koinCore)
}
