plugins {
    id(PluginIds.kotlin)
    id(PluginIds.kotlinKapt)
}

dependencies {
    implementation(project(ProjectModules.domain))

    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))

    implementation(Dependencies.kotlinxCoroutines)
    implementation(Dependencies.timber)
    implementation(Dependencies.dataMapper)
    kapt(Dependencies.dataMapperCompiler)
    implementation(Dependencies.Koin.koinCore)

    testImplementation(TestDependencies.kotlinxCoroutines)
    testImplementation(Dependencies.Koin.koinTest)
    testImplementation(TestDependencies.JUnit.junit)
    testImplementation(TestDependencies.JUnit.junitPlatformRunner)
    testImplementation(TestDependencies.Mockito.mockitoCore)
    testImplementation(TestDependencies.Mockito.mockitoInline)
    testImplementation(TestDependencies.Mockito.mockitoKotlin)
}