package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstLoginBtn.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.firstSignUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}