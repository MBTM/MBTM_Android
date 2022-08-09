package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Find_id_finish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_finish)

        binding.gotologin_finishid_btn.setOnClickListener({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })

        binding.resetpw_finishid_btn.setOnClickListener({
            val intent = Intent(this, FindIdChangePw::class.java)
            startActivity(intent)
        })
    }
}