package com.example.mbtm

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable")
data class User (
    @SerializedName(value = "id") var id: String,
    @SerializedName(value = "password") var password: String,
    @SerializedName(value = "passwordForCheck") var passwordCheck: String,
    @SerializedName(value = "nickName") var nickName: String = Math.random().toString(),
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "phone") var phone: String
)