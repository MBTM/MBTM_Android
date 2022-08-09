package com.example.mbtm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mbtm.databinding.ActivityStartMbtmBinding


class StartMBTMActivity : AppCompatActivity() {

    val mbtiArray = arrayOf(
        "ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP",
        "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP",
        "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    )

    lateinit var binding: ActivityStartMbtmBinding
    lateinit var userMbti: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartMbtmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startStartBtn.setOnClickListener {
            if (binding.startMbtmRg.selectedRadioButtonId != null) {
                userMbti = mbtiArray[binding.startMbtmRg.selectedRadioButtonId!!]
                Toast.makeText(this, userMbti + "이시군요", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, FirstActivity::class.java))
            } else {
                Toast.makeText(this, "MBTI를 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        binding.startTestBtn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://www.16personalities.com/ko/")
            startActivity(i)
        }


    }
}

