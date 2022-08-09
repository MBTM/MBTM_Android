package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FindPwEnterCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw_enter_code)
    }

    binding.get_code_tv.setOnClickListener({
        val intent = Intent(this, FindPwChangePw::class.java)
        startActivity(intent)
    })
}