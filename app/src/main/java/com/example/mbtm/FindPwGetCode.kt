package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FindPwGetCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw_get_code)

        binding.first_findpw_getcode_btn.setOnClickListener({
            val intent = Intent(this, FindPwEnterCode::class.java)
            startActivity(intent)
        })
    }
}