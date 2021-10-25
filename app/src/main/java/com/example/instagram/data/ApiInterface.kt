package com.example.instagram.data

import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.data.json.catagory.Category
import com.example.instagram.data.json.LoginResponse
import com.example.instagram.data.json.MyResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface ApiInterface {

    @POST("api/client/login")
    fun getClient(@Body user: ApiSignIn ) : Observable<MyResponse<LoginResponse>>

    @GET("api/categories")
    fun getCategory(): Observable<MyResponse<List<Category>>>

    @GET("api/categories/{id}")
    fun getCatalog(@Path ("id") id: Int): Observable<MyResponse<List<Catalog>>>

}