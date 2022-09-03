package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mbtm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.findIdTv.setOnClickListener{
            val intent = Intent(this, FindIdInputActivity::class.java)
            startActivity(intent)
        }


        binding.findPwTv.setOnClickListener{
            startActivity(Intent(this, FindPwGetCodeActivity::class.java))
        }

        binding.loginSignUpTv.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.loginLoginBtn.setOnClickListener {
            login()
        }

    }

    private fun login(){
        if (binding.loginIdPhoneEt.text.toString().isEmpty()) {
           Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.loginPasswordEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val id = binding.loginIdPhoneEt.text.toString()
        val password = binding.loginPasswordEt.text.toString()

        val authService = AuthService()
        authService.setLoginView(this)


        authService.login(User(id=id, password=password))
    }


    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveJwt2(jwt: String) {
        val spf = getSharedPreferences("auth2" , MODE_PRIVATE)
        val editor = spf.edit()

        editor.putString("jwt", jwt)
        editor.apply()
    }


    override fun onLoginSuccess(code: Int, result: Result) {
        when(code){
            1000 -> {
                saveJwt2(result.jwt)
                startMainActivity()
                Log.d("Gabang/login/1000", code.toString())
            }
        }
    }

    override fun onLoginFailure(code: Int, message: String) {
        when (code) {
            2016->{
                Log.d("Gabang/login/2016", message)
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            2030 -> {
                Log.d("Gabang/login/2030", message)
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            3014 -> {
                Log.d("Gabang/login/2030", message)
                Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            }
            2039 ->{
                Log.d("Gabang/login/2039", message)
                Toast.makeText(this, "존재하지 않는 계정입니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}