package com.github.kiolk.allmed

import android.app.Application
import com.facebook.stetho.Stetho
import com.github.kiolk.allmed.di.module.applicationModule
import com.github.kiolk.allmed.di.module.dataSourceModule
import com.github.kiolk.allmed.di.module.useCaseModule
import com.github.kiolk.allmed.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule, applicationModule, dataSourceModule, useCaseModule))
        }

        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }
}