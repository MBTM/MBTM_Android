package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mbtm.databinding.ActivityFindIdInputBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FindIdInput : AppCompatActivity(), FindIdView {

    lateinit var binding: ActivityFindIdInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFindIdInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstFindIdInputBtn.setOnClickListener { findId() }

    }

    // 이메일 가져오기
    private fun getUser(): User{
        val nickName: String = binding.nicknameInputEt.text.toString()
        val email : String = binding.loginEmailInputEt.text.toString()

        return User(nickName, email)
    }

    // 입력되지 않거나 확인되지 않으면 회원가입 진행되지 않게 만들기
    private fun findId() {
        if (binding.loginEmailInputEt.text.toString().isEmpty() && binding.nicknameInputEt.text.toString().isEmpty()){
            binding.findIdNicknameErrorTv.visibility = View.VISIBLE
            binding.findIdEmailErrorTv.visibility = View.VISIBLE
        }
        else if (binding.nicknameInputEt.text.toString().isEmpty()) {
            Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
            binding.findIdNicknameErrorTv.visibility = View.GONE
            return
        }
        else if (binding.loginEmailInputEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
            binding.findIdNicknameErrorTv.visibility = View.GONE
            return
        }



//        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
//        authService.signUp(getUser()).enqueue(object :Callback<AuthResponse>{
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                Log.d("YES/SIGNUP/SUCCESS", response.toString())
//                val resp: AuthResponse = response.body()!!
//                when (resp.code) {
//                    1000 -> finish()
//                    2033, 2034 -> {
//                        // 실패시 나오는것도 나오도록 하기
//                        binding.findIdNicknameErrorTv.visibility = View.VISIBLE
//                        binding.findIdNicknameErrorTv.text = resp.message
//                    }
//                    2039 -> {
//                        binding.findIdEmailErrorTv.visibility = View.VISIBLE
//                        binding.findIdEmailErrorTv.text = resp.message
//                    }
//
//                }
//            }
//
//            // 네트워크 연결 자체가 실패했을 때
//            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                Log.d("YES/SIGNUP/FAILURE", t.message.toString())
//            }
//
//
//
//        })
//        Log.d("YES/SIGNUP", "HELLO")

        val authService = AuthService()
        authService.setFindIdView(this)

        authService.findId(getUser())

        Log.d("SIGNUP-ACT/ASYNC", "Hello, FLO")

    }

    override fun onFindIdSuccess(code: Int, result: Result) {

        // 아이디 넘기기
        // intent.putExtra("아이디 값", EditText1.text.toString())

        Log.d("SIGNUP-ACT/ASYNC", "Find Success")

        finish()



    }

    override fun onFindIdFailure(code: Int, message: String) {
        fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
            Log.d("YES/SIGNUP/SUCCESS", response.toString())
            val resp: AuthResponse? = response.body()
            when (resp?.code) {
                2033, 2034 -> {
                    // 실패시 나오는것도 나오도록 하기
                    this.binding.findIdNicknameErrorTv.visibility = View.VISIBLE
                    this.binding.findIdNicknameErrorTv.text = resp.message
                }
                2039 -> {
                    binding.findIdEmailErrorTv.visibility = View.VISIBLE
                    binding.findIdEmailErrorTv.text = resp.message
                }
            }
        }
    }
}

//        val nickName: String = binding.enterNameInputTv.text.toString()
//        val email : String = binding.enterPhoneInputTv.text.toString()
//
//        val findDB = FindDatabase.getInstance(this)!!
//        val user = findDB.userDao().getUser(nickName, email)
//
//        user?.let{
//            Log.d("LOGIN_ACT/GET_USER", "userId: ${user.id}, $user")
//            saveJwt(user.id)
//            startActivity()
//        }
//        Toast.makeText(this, "회원정보가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun saveJwt(jwt:Int){
//        val spf = getSharedPreferences("auth", MODE_PRIVATE)
//        val editor = spf.edit()
//
//        editor.putInt("jwt", jwt)
//        editor.apply()
//    }
//
//    private fun startActivity(){
//        val intent = Intent(this, FindIdFinish::class.java)
//        startActivity(intent)
//    }


