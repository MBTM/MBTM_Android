package com.example.mbtm

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable")
data class User(
    @SerializedName(value = "id" ) var id: String? = null,
    @SerializedName(value = "password") var password: String? = null,
    @SerializedName(value = "passwordForCheck") var passwordCheck: String? = null,
    @SerializedName(value = "email") var email: String? = null,
    @SerializedName(value = "phone") var phone: String? = null,
    @SerializedName(value = "nickName") var nickName: String? = null,
    @SerializedName(value = "userIdx") var userIdx: Int? = null,
    @SerializedName(value = "mbti") var mbti: String? = null


)