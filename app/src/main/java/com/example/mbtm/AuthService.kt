package com.example.mbtm

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var findIdView: FindIdView

    fun setFindIdView(findIdView: FindIdView){
        this.findIdView = findIdView
    }

    fun findId(user:User){


        val findIdService = getRetrofit().create(AuthRetrofitInterface::class.java)

        findIdService.signUp(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("Ytemp", "asdf")

                val resp: AuthResponse = response.body()!!
                Log.d("go/code", resp.code.toString())
                when (val code = resp.code) {

                    1000 -> findIdView.onFindIdSuccess(code, resp.result!!)
                    else -> findIdView.onFindIdFailure(code, resp.message)
                }

//                if(response.isSuccessful){
//                    val resp: AuthResponse? = response.body()
//                    Log.d("YES/SIGNUP/SUCCESS", resp?.code.toString())
//                    when (resp?.code) {
//                        1000 -> findIdView.onFindIdSuccess()
//                        else -> findIdView.onFindIdFailure()
//                    }
//
//                }

            }

            // 네트워크 연결 자체가 실패했을 때
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("YES/SIGNUP/FAILURE", t.message.toString())
            }



        })
    }
}