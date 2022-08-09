package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FindPwChangePw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw_change_pw)
    }

    binding.ok_btn_changepw_tv.setOnClickListener({
        val intent = Intent(this, FinishChangePw::class.java)
        startActivity(intent)
    })

}