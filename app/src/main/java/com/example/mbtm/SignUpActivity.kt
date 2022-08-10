package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.mbtm.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpNextBtn.setOnClickListener {
            Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show()
            Log.d("OKOK/CALL-SIGNUP", "hello")
//            signUp()
        }

//        SignUpVPadapter(this)
        initAdapter()
    }

    private fun initAdapter() {

        //ViewPagerAdapter 초기화
        val signUpVPadapter = SignUpVPadapter(this)
        signUpVPadapter.addFragment(SignUpFirstFragment())
        signUpVPadapter.addFragment(SignUpSecondFragment())

        //ViewPager2와 Adapter 연동
        binding.signUpInputVp.adapter = signUpVPadapter

//        signUpVPadapter.set(false);


//    }
//
//    private fun getUser(): User {
//        val id: String = binding.signUpIdEt.text.toString()
//        val pwd: String = binding.signUpPasswordEt.text.toString()
//        val pwdCheck: String = binding.signUpPasswordConfirmEt.text.toString()
//        val nickName: String = "adf;lgkjd;fl"
//        val email: String = binding.signUpEmailEt.text.toString()
//        val phone: String = binding.signUpPhoneEt.text.toString()
//
//        return User(id, pwd, pwdCheck, nickName, email, phone)
//    }
//
//    private fun signUp() {
//        if (binding.signUpIdEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
//        } else if (binding.signUpPasswordEt.text.isEmpty()) {
//            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
//        } else if (binding.signUpPasswordConfirmEt.text.isEmpty()) {
//            Toast.makeText(this, "확인용 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
//        } else if (binding.signUpEmailEt.text.isEmpty()) {
//            Toast.makeText(this, "이메일 주소를 입력해주세요", Toast.LENGTH_SHORT).show()
//        } else if (binding.signUpPhoneEt.text.isEmpty()) {
//            Toast.makeText(this, "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show()
//        }
//
//        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
//        authService.signUp(getUser()).enqueue(object : Callback<AuthResponse> {
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                Log.d("OKOK/SIGNUP/SUCCESS", response.toString())
//                val resp: AuthResponse = response.body()!!
//                Log.d("OKOK/SIGNUP/CODE", resp.code.toString())
//                when (resp.code) {
//                    1000 -> {
//                        Toast.makeText(this@SignUpActivity, "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                }
//
//                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                    Log.d("OKOK/SIGNUP/FAILURE", t.message.toString())
//                }
//
//            })
//
//            Log.d("OKOK/SIGNUP", "hello")
//        }

    }
}
