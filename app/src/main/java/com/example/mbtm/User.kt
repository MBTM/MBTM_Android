package com.example.mbtm

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserTable")

data class User(

    @SerializedName(value = "nickName") var nickName: String,
    @SerializedName(value = "email") var email: String

)
