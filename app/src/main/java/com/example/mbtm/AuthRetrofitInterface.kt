package com.example.mbtm

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.userAgent
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRetrofitInterface {

    @POST("/users/searchId")
    fun findId(@Body user: User): Call<AuthResponse>



}
