package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFindPwGetCodeBinding

class FindPwGetCodeActivity : AppCompatActivity() {

    lateinit var binding: ActivityFindPwGetCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFindPwGetCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

 //       empty()

        binding.firstFindPwGetcodeBtn.setOnClickListener {
            val intent = Intent(this, FindPwEnterCodeActivity::class.java)
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
