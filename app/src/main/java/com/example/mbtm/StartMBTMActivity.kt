package com.example.mbtm

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mbtm.databinding.ActivityStartMbtmBinding
import com.example.mbtm.gridRadioGroup.OnCheckedChangeListener


class StartMBTMActivity : AppCompatActivity() {

    val mbtiArray = arrayOf(
        "ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP",
        "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP",
        "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    )

    val colorArray = arrayOf(
        "798454", "32A694", "F37661", "A6C151", "73509B", "CC3338",
        "F57C26", "77236D", "20B9F2", "249551", "E6AC2C", "166C78",
        "A8C740", "DF3E74", "1D3A65", "DD5827"
    )

    lateinit var binding: ActivityStartMbtmBinding
    lateinit var userMbti: String
    lateinit var prev: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartMbtmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMbtiColor()

        val radioButton = findViewById<RadioButton>(R.id.sign_up_mbti_istj_btn)

        val radioGroup: gridRadioGroup = binding.startMbtmRg

        binding.startMbtmRg.setOnCheckedChangeListener(object : OnCheckedChangeListener{

            override fun onCheckedChanged(group: gridRadioGroup?, checkedId: Int) {
                // checkedId -> Radio Group 에서 선택한 id

                // 다른 선택지를 선택했었다면, 새롭게 선택할 때 기존 선택지 색 되돌리기
                if (::prev.isInitialized) {
                    val prevRadioButton = findViewById<RadioButton>(prev.toInt())
                    val prevRadioButtonColor = "#33" + colorArray[mbtiArray.indexOf(prevRadioButton.text)]
                    prevRadioButton.setBackgroundColor(Color.parseColor(prevRadioButtonColor))
                }

                // 선택시 radio Button 의 background color 변경
                prev = checkedId.toString()
                val radioButton = findViewById<RadioButton>(checkedId)
                val radioButtonColor = "#99" + colorArray[mbtiArray.indexOf(radioButton.text)]
                radioButton.setBackgroundColor(Color.parseColor(radioButtonColor))
            }


        })

        binding.startStartBtn.setOnClickListener {
            if (binding.startMbtmRg.checkedCheckableImageButtonId == -1) {
                Toast.makeText(this, "MBTI를 선택해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val userMbti: String = (findViewById<RadioButton>(binding.startMbtmRg.checkedCheckableImageButtonId)).text as String
//                userMbti = binding.startMbtmRg.checkedCheckableImageButtonId.text
                Toast.makeText(this, userMbti + "이시군요", Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this, FirstActivity::class.java))
            }
        }

        binding.startTestBtn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://www.16personalities.com/ko/")
            startActivity(i)
        }


    }

    private fun initMbtiColor() {
        for(mbti in mbtiArray) {

        }
    }
}

