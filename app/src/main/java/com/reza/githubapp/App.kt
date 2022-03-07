package com.reza.githubapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.reza.githubapp.di.appComponents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App: Application(){
    override fun onCreate() {
        super.onCreate()

        initDI()
        initTimber()
        initStetho()
    }


    private fun initDI() {
        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(appComponents)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
}