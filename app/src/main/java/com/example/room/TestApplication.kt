package com.example.room

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestApplication : Application() {

    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()
        //app bazlı bütün uygulamalar burada yapılır.

        appDatabase = AppDatabase.getDatabase(this)

    }
}