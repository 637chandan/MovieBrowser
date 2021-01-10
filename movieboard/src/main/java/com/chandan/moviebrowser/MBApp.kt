package com.chandan.moviebrowser

import android.app.Application
import com.chandan.moviebrowser.di.appModule
import com.chandan.moviebrowser.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MBApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MBApp)
            modules(listOf(
                appModule,
                viewModule
            ))
        }
    }
}


