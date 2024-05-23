package com.sopt.kakaobank

import android.app.Application
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }
}