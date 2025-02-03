package com.hubx.myplant

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Uygulama genelinde gerekli başlatma işlemleri burada yapılabilir.
    }
}