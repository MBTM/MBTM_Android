package com.example.mbtm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val pref = getSharedPreferences("checkFirst", MODE_PRIVATE)
//        val checkFirst = pref.getBoolean("checkFirst", false)
//        if (!checkFirst) {
//            val editor = pref.edit()
//            editor.putBoolean("checkFirst", true)
//            editor.commit()
            startActivity(Intent(this, FirstActivity::class.java))
//        }
    }
}

//
//class MainActivity : AppCompatActivity() {
//    var moveButton: Button? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        moveButton = findViewById(R.id.moveButton)
//        moveButton.setOnClickListener(onClickListener)
//
////        최초 실행 여부를 판단 ->>>
//        val pref = getSharedPreferences("checkFirst", MODE_PRIVATE)
//        val checkFirst = pref.getBoolean("checkFirst", false)
//        if (checkFirst == false) {
//            // 앱 최초 실행시 하고 싶은 작업
//            val editor = pref.edit()
//            editor.putBoolean("checkFirst", true)
//            editor.commit()
//            val intent = Intent(this@MainActivity, TutorialActivity::class.java)
//            startActivity(intent)
//            finish()
//        } else {
//            // 최초 실행이 아닐때 진행할 작업
//        }
//        //          <<<-
//    }
//
//    var onClickListener: Button.OnClickListener = object : OnClickListener() {
//        fun onClick(view: View) {
//            when (view.getId()) {
//                R.id.moveButton -> {
//                    val intent = Intent(this@MainActivity, TutorialActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            }
//        }
//    }
//}