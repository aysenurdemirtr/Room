package com.example.room

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestApplication : Application() {

    // burada benim database'i injectlememe grek kalmadı
    //çünkü ben module'de @ApplicationContext ile hiltle injectlemiş oldum.
    // bu sayede benim burada ekstra olarak database'i başlatmama gerek yok.
    //module içerisinde zaten başlatmış oldum.
}