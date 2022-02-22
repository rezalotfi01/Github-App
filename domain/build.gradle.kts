plugins {
    id(PluginIds.kotlin)
    id(PluginIds.kotlinKapt)
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))

    implementation(Dependencies.kotlinxCoroutines)
    implementation(Dependencies.dataMapper)
    kapt(Dependencies.dataMapperCompiler)
    implementation(Dependencies.Koin.koinCore)
}