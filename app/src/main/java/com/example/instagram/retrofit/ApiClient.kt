package com.example.instagram.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private lateinit var retrofit: Retrofit
        private lateinit var gson: Gson

        fun getClient() : Retrofit {
            if (!:: gson.isInitialized ) {
                gson = GsonBuilder()
                    .setLenient()
                    .create()
            }
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://test.vivian -legend.uz/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}