package com.csi.bottomnavigationactivity

import android.app.Application
import androidx.viewbinding.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

            Timber.plant(DebugTree())

    }
}