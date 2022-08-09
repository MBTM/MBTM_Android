package com.example.mbtm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class findIdInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_input)

        binding.first_findId_input_btn.setOnClickListener({
            val intent = Intent(this, Find_id_finish::class.java)
            startActivity(intent)
        })
    }
}