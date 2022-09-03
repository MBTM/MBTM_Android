package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbtm.databinding.ActivityFindPwEnterCodeBinding

class FindPwEnterCodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindPwEnterCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFindPwEnterCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getProveCodeTv.setOnClickListener {
            val intent = Intent(this, FindPwChangePwActivity::class.java)
            startActivity(intent)
        }
    }

}