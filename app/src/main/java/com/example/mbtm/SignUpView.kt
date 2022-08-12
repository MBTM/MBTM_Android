package com.example.mbtm

interface SignUpView {
    fun onSignUpSuccess(code: Int, result: Result)
    fun onSignUpFailure(code: Int, message: String)
}