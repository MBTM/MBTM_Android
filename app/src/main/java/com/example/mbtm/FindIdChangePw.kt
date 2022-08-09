package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FindIdChangePw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_change_pw)


        binding.first_findId_finishpw_btn.setOnClickListener({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })

        binding.gotomain_finishpw_tv.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}