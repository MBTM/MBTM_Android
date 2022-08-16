package com.example.mbtm

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao

// User에 대한 정보 넣기
interface UserDao {

    @Insert
    fun insert(user:User)

    @Query("SELECT * FROM UserTable")
    fun getUsers(): List<User>

    // 한명의 정보만 가져오기
    @Query("SELECT * FROM UserTable WHERE nickname = :nickname AND email = :email")
    fun getUser(nickname:String, email:String) : User?
}