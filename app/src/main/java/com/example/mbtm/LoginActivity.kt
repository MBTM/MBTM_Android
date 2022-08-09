package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.find_id_tv.setOnClickListener({
            val intent = Intent(this, findIdInput::class.java)
            startActivity(intent)
        })

        binding.find_pw_tv.setOnClickListener({
            val intent = Intent(this, FindPwEnterCode::class.java)
            startActivity(intent)
        })



        setContentView(R.layout.activity_login)
    }
}