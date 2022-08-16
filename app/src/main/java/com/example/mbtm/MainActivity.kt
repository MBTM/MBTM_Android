package com.example.mbtm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val pref = getSharedPreferences("checkFirst", MODE_PRIVATE)
////        val checkFirst = pref.getBoolean("checkFirst", false)
////        if (!checkFirst) {
////            val editor = pref.edit()
////            editor.putBoolean("checkFirst", true)
//            editor.commit()
        startActivity(Intent(this, FirstActivity::class.java))
//        val fragment_mbti = SignUpMbtiFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.sign_up_mbti_fragment, fragment_mbti).commit()
//        }
    }
}