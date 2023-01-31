package com.example.taskapp.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(val context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isUserSeen():Boolean{
        return pref.getBoolean(SEEN_KEY,false)
    }

    fun saveSeen(){
        pref.edit().putBoolean(SEEN_KEY,true).apply()
    }

    //age
    fun setAge(age: String) {
        pref.edit().putString(AGE_KEY, age).apply()
    }

    fun getAge(): String {
        return pref.getString(AGE_KEY, "").toString()
    }

    fun saveName(name: String) {
        pref.edit().putString(AGE_KEY, name).apply()
    }

    fun getName(): String {
        return pref.getString(AGE_KEY, "").toString()
    }


    fun saveImage(image: String) {
        pref.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String {
        return pref.getString(IMAGE_KEY, "").toString()
    }


    companion object {
         const val PREF_NAME = "pref_task_manager"
         const val AGE_KEY = "age_pref"
        const val SEEN_KEY = "Seen,Key"
        const val IMAGE_KEY = "image.key"
    }
}