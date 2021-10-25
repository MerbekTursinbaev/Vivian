package com.example.instagram.di

import android.content.Context

class Settings(context: Context) {

    private val prefs = context.getSharedPreferences("MyShared",Context.MODE_PRIVATE)

    var isSign : Int
    set(value) = prefs.edit().putInt("isSign",value).apply()
    get() = prefs.getInt("isSign",0)

}