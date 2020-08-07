package com.benrostudios.lastmile

import android.app.Application
import com.benrostudios.lastmile.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LastMileApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@LastMileApplication)
            modules(appComponent)
        }
    }
}