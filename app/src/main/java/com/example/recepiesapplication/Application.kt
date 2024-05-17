package com.example.recepiesapplication

import android.app.Application

class Application : Application() {
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}