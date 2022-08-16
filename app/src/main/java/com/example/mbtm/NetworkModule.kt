package com.example.mbtm

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.addHeaderLenient
import okhttp3.internal.userAgent
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

const val BASE_URL="https://www.dorisdev.shop"

fun getRetrofit(): Retrofit {

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val headerInterceptor = Interceptor { val request = it.request().newBuilder().addHeader("User-Agent", userAgent) .build()
        return@Interceptor it.proceed(request) }

    val client = OkHttpClient.Builder() .addInterceptor(headerInterceptor) .addInterceptor(httpLoggingInterceptor) .build()

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    return retrofit

}