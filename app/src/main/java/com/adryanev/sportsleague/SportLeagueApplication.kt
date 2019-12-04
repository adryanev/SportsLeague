package com.adryanev.sportsleague

import android.app.Application
import com.adryanev.sportsleague.di.appModule
import com.adryanev.sportsleague.di.networkModule
import com.adryanev.sportsleague.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class SportLeagueApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@SportLeagueApplication)
            modules(listOf(appModule, viewModelModule, networkModule))
        }

    }
}