package com.example.mbtm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val pref = getSharedPreferences("checkFirst", MODE_PRIVATE)
////        val checkFirst = pref.getBoolean("checkFirst", false)
////        if (!checkFirst) {
////            val editor = pref.edit()
////            editor.putBoolean("checkFirst", true)
//            editor.commit()
        //startActivity(Intent(this, FirstActivity::class.java))
//        val fragment_mbti = SignUpMbtiFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.sign_up_mbti_fragment, fragment_mbti).commit()
//        }/
    }

    private fun saveJwt2(jwt: String) {
        val spf = getSharedPreferences("auth2" , MODE_PRIVATE)
        val editor = spf.edit()

        editor.putString("jwt", jwt)
        editor.apply()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginSuccess(code: Int, result: Result) {
        when(code){
            1000 -> {
                saveJwt2(result.jwt)
                startMainActivity()
                Log.d("Gabang/login/1000", code.toString())
            }
            else -> {
                startActivity(Intent(this, FirstActivity::class.java))
            }
        }
    }

    override fun onLoginFailure(code: Int, message: String) {
        startActivity(Intent(this, FirstActivity::class.java))
    }

}