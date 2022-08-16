package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mbtm.databinding.ActivityFindIdFinishBinding

class FindIdFinish : AppCompatActivity() {

    lateinit var binding: ActivityFindIdFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFindIdFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 아이디 가져오기
//        if(intent.hasExtra("name")){
//            textView.text=intent.getStringExtra("name")
//        }


        // Log.d("회원님의 아이디는\n"+"입니다.")
        binding.gotologinFinishidBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }

        binding.resetpwFinishIdBtn.setOnClickListener {
            val intent = Intent(this, FindIdChangePw::class.java)
            startActivity(intent)
        }
    }


}