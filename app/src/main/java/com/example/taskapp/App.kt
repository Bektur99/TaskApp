package com.example.taskapp

import android.app.Application
import androidx.room.Room
import com.example.taskapp.data.database.AppDatabase
import com.google.firebase.FirebaseApp

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }


    companion object {
        lateinit var db: AppDatabase
    }

}