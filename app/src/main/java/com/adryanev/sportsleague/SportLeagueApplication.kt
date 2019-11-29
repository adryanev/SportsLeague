package com.adryanev.sportsleague

import android.app.Application
import com.facebook.stetho.Stetho
import timber.log.Timber

class SportLeagueApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())

    }
}