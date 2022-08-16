package com.example.mbtm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.example.mbtm.databinding.ActivityFindIdChangePwBinding
import java.util.regex.Pattern.compile

class FindIdChangePw : AppCompatActivity() {

    lateinit var binding: ActivityFindIdChangePwBinding



   // lateinit var askChangePw: editText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindIdChangePwBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.firstFindIdIdChangepwBtn.setOnClickListener {
            val intent = Intent(this, FindIdFinish::class.java)
            startActivity(intent)
        }

    }

    // 비밀번호 확인하기
//    private fun askChangePw(){
//
//
//        login_password_confirm_idchangepw_et
//
//        loginPasswordConfirmIdchangeEt.addTextChangedListener (object : TextWatcher {
//            //입력이 끝났을 때
//            //4. 비밀번호 일치하는지 확인
//            override fun afterTextChanged(p0: Editable?) {
//                if(edit_up_pw1.getText().toString().equals(edit_up_pw2.getText().toString())){
//                    pw_confirm.setText("비밀번호가 일치합니다.")
//                    pw_confirm.setTextColor(colorMain)
//                    // 가입하기 버튼 활성화
//                    sign_up_btn2.isEnabled=true
//                }
//                else{
//                    pw_confirm.setText("비밀번호가 일치하지 않습니다.")
//                    pw_confirm.setTextColor(red)
//                    // 가입하기 버튼 비활성화
//                    sign_up_btn2.isEnabled=false
//                }
//            }
//            //입력하기 전
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//            //텍스트 변화가 있을 시
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if(edit_up_pw1.getText().toString().equals(edit_up_pw2.getText().toString())){
//                    pw_confirm.setText("비밀번호가 일치합니다.")
//                    pw_confirm.setTextColor(colorMain)
//                    // 가입하기 버튼 활성화
//                    sign_up_btn2.isEnabled=true
//                }
//                else{
//                    pw_confirm.setText("비밀번호가 일치하지 않습니다.")
//                    pw_confirm.setTextColor(red)
//                    // 가입하기 버튼 비활성화
//                    sign_up_btn2.isEnabled=false
//                }
//            }
//        })
//    }
}
