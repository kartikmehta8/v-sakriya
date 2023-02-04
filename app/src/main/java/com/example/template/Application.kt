package com.example.template

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant
import javax.inject.Inject

@HiltAndroidApp
class Application :Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            plant(Timber.DebugTree())
        }
    }
}