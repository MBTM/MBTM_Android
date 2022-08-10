package com.example.mbtm

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mbtm.databinding.ActivityStartMbtmBinding
import com.example.mbtm.gridRadioGroup.OnCheckedChangeListener
import java.nio.file.Files.find


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

        val radioGroup: gridRadioGroup = binding.startMbtmRg

        binding.startMbtmRg.setOnCheckedChangeListener(object : OnCheckedChangeListener{

            override fun onCheckedChanged(group: gridRadioGroup?, checkedId: Int) {
//                val prevRadioButton = findViewById<RadioButton>(prev.toInt())
//                Log.d("okok/", prev)
//                radioButton.setBackground
                if (::prev.isInitialized) {
                    val prevRadioButton = findViewById<RadioButton>(prev.toInt())
                    val prevRadioButtonColor = "#33" + colorArray[mbtiArray.indexOf(prevRadioButton.text)]
//                    Log.d("OKOK/FIND", find<String>(colorArray, prevRadioButton.text).toString())

                    prevRadioButton.setBackgroundColor(Color.parseColor(prevRadioButtonColor))
//                    prevRadioButton.setBackgroundResource(R.drawable.background_mbti_select)
//
//                    prevRadioButton.setBackgroundResource(R.drawable.background_mbti_selector);
//                    prevRadioButton.setBackgroundColor(Color.parseColor("#dca8c3"));
//                    prevRadioButton.setBackgroundColor(getResources().getColor(androidx.appcompat.R.color.material_blue_grey_800));

                }
                prev = checkedId.toString()
                val radioButton = findViewById<RadioButton>(checkedId)
                val radioButtonColor = "#99" + colorArray[mbtiArray.indexOf(radioButton.text)]
//                radioButton.buttonTintList =
//                    ColorStateList.valueOf(ContextCompat.getColor(this@StartMBTMActivity, R.color.darker_gray))
                radioButton.setBackgroundColor(Color.parseColor(radioButtonColor))
//                radioButton.setTextColor(Color.parseColor("#FFFFFF"))
//                Log.d("OKOK/MBTI_ID/", mbtiArray[checkedId + 1] + binding.signUpMbtiIstjBtn.text)
//                if (checkedId == R.id.sign_up_mbti_istj_btn){
//
//                    Log.d("OKOK/MBTI_ID/", R.id.sign_up_mbti_istj_btn.toString())
//                    Log.d("OKOK/MBTI_ID/", R.id.sign_up_mbti_isfj_btn.toString())
//                }
            }

        })

        binding.startStartBtn.setOnClickListener {
            if (binding.startMbtmRg.checkedCheckableImageButtonId == -1) {
                Toast.makeText(this, "MBTI를 선택해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val userMbti: String = (findViewById<RadioButton>(binding.startMbtmRg.checkedCheckableImageButtonId)).text as String
//                userMbti = binding.startMbtmRg.checkedCheckableImageButtonId.text
                Toast.makeText(this, userMbti + "이시군요", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, FirstActivity::class.java))
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

