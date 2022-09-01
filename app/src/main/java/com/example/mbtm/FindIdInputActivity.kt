package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mbtm.databinding.ActivityFindIdInputBinding
import retrofit2.Call
import retrofit2.Response


class FindIdInputActivity : AppCompatActivity() {

    lateinit var binding: ActivityFindIdInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFindIdInputBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    // 이메일 가져오기


}

//        val nickName: String = binding.enterNameInputTv.text.toString()
//        val email : String = binding.enterPhoneInputTv.text.toString()
//
//        val findDB = FindDatabase.getInstance(this)!!
//        val user = findDB.userDao().getUser(nickName, email)
//
//        user?.let{
//            Log.d("LOGIN_ACT/GET_USER", "userId: ${user.id}, $user")
//            saveJwt(user.id)
//            startActivity()
//        }
//        Toast.makeText(this, "회원정보가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
//    }
//
//    private fun saveJwt(jwt:Int){
//        val spf = getSharedPreferences("auth", MODE_PRIVATE)
//        val editor = spf.edit()
//
//        editor.putInt("jwt", jwt)
//        editor.apply()
//    }
//
//    private fun startActivity(){
//        val intent = Intent(this, FindIdFinish::class.java)
//        startActivity(intent)
//    }


