package com.example.taskapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskapp.ui.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabasae : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}