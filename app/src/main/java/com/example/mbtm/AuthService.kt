package com.example.mbtm

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class AuthService {
    private lateinit var findIdView: FindIdView
    private lateinit var signUpView: SignUpView
    private lateinit var loginView: LoginView


    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }

    fun setFindIdView(findIdView: FindIdView){
        this.findIdView = findIdView
    }
    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
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


    fun findId(user:User){


        val findIdService = getRetrofit().create(AuthRetrofitInterface::class.java)

        findIdService.findId(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("Gabang/response", response.toString())


                val resp: AuthResponse = response.body()!!

                Log.d("go/code", resp.code.toString())

                when (val code = resp.code) {

                    1000 -> findIdView.onFindIdSuccess(code, resp.result!!)
                    else -> findIdView.onFindIdFailure(code, resp.message)
                }


            }

            // 네트워크 연결 자체가 실패했을 때
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("Gabang/SIGNUP/FAILURE", t.message.toString())
            }



        })
    }

    // 로그인 구현
    fun login(user: User) {

        val LoginService = getRetrofit().create(AuthRetrofitInterface::class.java)

        Log.d("Gabang/User", user.toString() )


        LoginService.login(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("Gabang/login/server", response.body().toString())
                val resp: AuthResponse = response.body()!!

            //    Log.d("Gabang/login/code", resp.code.toString())

                when (val code = resp.code) {

                    1000 -> loginView.onLoginSuccess(code, resp.result!!)
                    else -> loginView.onLoginFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("Gabang/Login/FAILURE", t.message.toString())
            }


        })
    }

}