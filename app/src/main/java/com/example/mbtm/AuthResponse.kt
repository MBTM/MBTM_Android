package com.example.mbtm

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "password") val password: String,
    @SerializedName(value = "result") val result: Result?
)

data class Result(

    @SerializedName(value = "id") var id: String,

    @SerializedName(value = "userIdx") var userIdx: Int,

    @SerializedName(value = "jwt") var jwt: String
)
