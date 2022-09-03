package com.example.mbtm

interface LoginView {
    fun onLoginSuccess(code: Int, result: Result)
    fun onLoginFailure(code: Int, message: String)
}