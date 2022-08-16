package com.example.mbtm

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users")
    fun signUpFirst(@Body user:User): Call<AuthResponse>

    @POST("/users/nickName")
    fun signUpSecond(@Header("X-ACCESS-TOKEN") jwt: String, @Body user: User) : Call<AuthResponse>
}