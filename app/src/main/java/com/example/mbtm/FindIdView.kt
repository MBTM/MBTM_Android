package com.example.mbtm

interface FindIdView {
    fun onFindIdSuccess(code:Int, result: Result)
    fun onFindIdFailure(code:Int, message: String)
}