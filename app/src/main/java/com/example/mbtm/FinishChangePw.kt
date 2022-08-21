package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFindIdFinishChangePwBinding
import com.example.mbtm.databinding.ActivityFindIdInputBinding

class FinishChangePw : AppCompatActivity() {

    lateinit var binding: ActivityFindIdFinishChangePwBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindIdFinishChangePwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstFindIdFinishChangePwBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.gotomainFinishpwTv.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
    }
}