package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.findIdTv.setOnClickListener{
            val intent = Intent(this, FindIdInput::class.java)
            startActivity(intent)
        }


        binding.findPwTv.setOnClickListener{
            // val intent = Intent(this, FindPwEnterCode::class.java)
            startActivity(Intent(this, FindPwGetCode::class.java))
        }

        binding.loginSignUpTv.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }


    }

}