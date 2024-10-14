package com.example.room.ui.hilt

import android.app.Application
import com.example.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltTestApplication : Application() {

    lateinit var appDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        //app bazlı bütün uygulamalar burada yapılır.
        appDatabase = AppDatabase.getDatabase(this)

    }
}