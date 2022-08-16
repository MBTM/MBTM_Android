package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityLoginBinding
import android.content.Intent

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




    }
}