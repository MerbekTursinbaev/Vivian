package com.example.instagram.di

import com.example.instagram.data.ApiInterface
import com.example.instagram.retrofit.ui.categories.catalog.CategoryViewModel
import com.example.instagram.retrofit.ui.categories.c.CatalogViewModel
import com.example.instagram.retrofit.ui.order.catalog.OrderCatalogViewModel
import com.example.instagram.retrofit.ui.order.category.OrderCategoryViewModel
import com.example.instagram.retrofit.ui.signin.SignInViewModel
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "http://test.vivian-legend.uz/"

val dataModule = module {

    single {
        GsonBuilder()
            .setLenient()
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(ApiInterface::class.java)
    }

    single {
        Settings(androidApplication().applicationContext)
    }
}

val viewModelModule = module {
    viewModel { SignInViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { CatalogViewModel(get()) }
    viewModel { OrderCatalogViewModel(get()) }
    viewModel { OrderCategoryViewModel(get()) }
}

