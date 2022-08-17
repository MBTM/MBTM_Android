package com.example.mbtm

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var signUpView: SignUpView

    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }

    fun signUpFirst(user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.signUpFirst(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val resp: AuthResponse = response.body()!!
                when (val code = resp.code) {
                    1000 -> signUpView.onSignUpSuccess(code, resp.result!!)
                    else -> signUpView.onSignUpFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("OKOK/SIGNUP/FAILURE", t.message.toString())
            }

        })
    }

    fun signUpSecond(jwt: String, user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.signUpSecond(jwt, user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val resp: AuthResponse = response.body()!!
                when (val code = resp.code) {
                    1000 -> signUpView.onSignUpSuccess(code, resp.result!!)
                    else -> signUpView.onSignUpFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("OKOK/SIGNUP/FAILURE", t.message.toString())
            }

        })
    }

    fun signUpMbti(jwt: String, user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.signUpMbti(jwt, user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                val resp: AuthResponse = response.body()!!
                when (val code = resp.code) {
                    1000 -> signUpView.onSignUpSuccess(code, resp.result!!)
                    else -> signUpView.onSignUpFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("OKOK/SIGNUP/FAILURE", t.message.toString())
            }

        })
    }

}