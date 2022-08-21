package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFindIdInputBinding
import com.example.mbtm.databinding.ActivityFindPwChangePwBinding

class FindPwChangePw : AppCompatActivity() {

    lateinit var binding: ActivityFindPwChangePwBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPwChangePwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.okBtnChangepwTv.setOnClickListener {
            val intent = Intent(this, FinishChangePw::class.java)
            startActivity(intent)
        }
    }



}