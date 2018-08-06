package com.victormotogna.favereads

import android.app.Application
import com.victormotogna.favereads.injection.AppModules
import org.koin.android.ext.android.releaseProperties
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.android.startKoin

class FaveReadsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, AppModules.modules)
        setProperty("application-context", applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        releaseProperties("application-context")
    }
}