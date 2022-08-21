//package com.example.mbtm
//
//import android.content.Intent
//import android.content.SharedPreferences
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Toast
//import com.example.mbtm.databinding.ActivityFindIdFinishBinding
//import javax.xml.transform.Result
//
//class FindIdFinish : AppCompatActivity() {
//
//    lateinit var binding: ActivityFindIdFinishBinding
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
////        findIdFinish()
//
//        super.onCreate(savedInstanceState)
//        binding = ActivityFindIdFinishBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
////        fun finishUser(): Result{
////            val nickName: String = binding.yourIdFinishidTv.text.toString()
////            return Result(userIdx, id)
////        }
////
////        val authService = AuthService()
////        authService.setFindIdView(this)
////
////        authService.findId(getUser())
//
//        Log.d("SIGNUP-ACT/ASYNC", "Hello, FLO")
//
//
//        // 아이디 가져오기
////        if(intent.hasExtra("name")){
////            textView.text=intent.getStringExtra("name")
////        }
//
//
//
//        // Log.d("회원님의 아이디는\n"+"입니다.")
//        binding.gotologinFinishidBtn.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//
//            startActivity(intent)
//        }
//
//        binding.resetpwFinishIdBtn.setOnClickListener {
//            val intent = Intent(this, FindIdChangePw::class.java)
//            startActivity(intent)
//        }
//    }
////
////    // 아이디나오기
////    private fun getUser(): User{
////        val nickName: String = binding.nicknameInputEt.text.toString()
////        val email : String = binding.loginEmailInputEt.text.toString()
////
////        return User(nickName, email)
////    }
////
////    private fun saveJwtUserIdx(id: String, userIdx:Int) {
////        val spf: SharedPreferences = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
////        val editor = spf.edit()
////        editor.putString("id", id)
////        editor.putInt("userIdx", userIdx)
////        editor.apply()
////    }
////
////    private fun findIdFinish() {
////
////        val authService = AuthService()
////        authService.setFindIdView(this)
////
////        authService.findId(getUser())
////
////        Log.d("findIdFinish", "findIdFinish")
////
////    }
//
//
//
//}