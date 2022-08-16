package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import androidx.recyclerview.widget.AsyncDifferConfig
import com.example.mbtm.databinding.ActivityFindIdInputBinding
import com.example.mbtm.databinding.ActivityFindPwGetCodeBinding

class FindPwGetCode : AppCompatActivity() {

    lateinit var binding: ActivityFindPwGetCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFindPwGetCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

 //       empty()

        binding.firstFindPwGetcodeBtn.setOnClickListener {
            val intent = Intent(this, FindPwEnterCode::class.java)
            startActivity(intent)

        }
    }

//    private fun empty() {
//
//        if (binding.loginIdPhoneGetcodeEt.getText().toString().equals("") || binding.loginPasswordGetcodeEt.getText().toString().equals("")){
//            binding.firstFindPwGetcodeBtn.visibility = INVISIBLE
//            binding.firstFindpwGetcodeBtn2.visibility = VISIBLE
//
//        }

}
