package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFindPwChangePwBinding

class FindPwChangePwActivity : AppCompatActivity() {

    lateinit var binding: ActivityFindPwChangePwBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindPwChangePwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.okBtnChangepwTv.setOnClickListener {
            val intent = Intent(this, FinishChangePwActivity::class.java)
            startActivity(intent)
        }
    }



}