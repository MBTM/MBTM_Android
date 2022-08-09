package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FinishChangePw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_finish_change_pw)

        binding.first_findId_idchangepw_btn.setOnClickListener({
            val intent = Intent(this, FinishChangePw::class.java)
            startActivity(intent)
        })

        binding.first_findId_idchangepw_btn.setOnClickListener({
            val intent = Intent(this, FinishChangePw::class.java)
            startActivity(intent)
        })
    }
}