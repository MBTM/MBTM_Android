package com.example.mbtm

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mbtm.databinding.FragmentSignUpMbtiBinding
import com.example.mbtm.gridRadioGroup.OnCheckedChangeListener


class SignUpMbtiFragment : Fragment(), SignUpView  {

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


    lateinit var navController: NavController
    lateinit var binding: FragmentSignUpMbtiBinding
    lateinit var prev: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.startMbtmRg.setOnCheckedChangeListener(object : OnCheckedChangeListener {

            override fun onCheckedChanged(group: gridRadioGroup?, checkedId: Int) {
                if (::prev.isInitialized) {
                    val prevRadioButton = view.findViewById<RadioButton>(prev.toInt())
                    val prevRadioButtonColor =
                        "#33" + colorArray[mbtiArray.indexOf(prevRadioButton.text)]
                    prevRadioButton.setBackgroundColor(Color.parseColor(prevRadioButtonColor))
                }

                prev = checkedId.toString()
                val radioButton = view.findViewById<RadioButton>(checkedId)
                val radioButtonColor = "#99" + colorArray[mbtiArray.indexOf(radioButton.text)]
                radioButton.setBackgroundColor(Color.parseColor(radioButtonColor))
            }
        })

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpMbtiBinding.inflate(inflater, container, false)
        binding.startStartBtn.setOnClickListener {
            if (binding.startMbtmRg.checkedCheckableImageButtonId == -1) {
                Toast.makeText(activity, "MBTI를 선택해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val userMbti: String =
                    (requireView().findViewById<RadioButton>(binding.startMbtmRg.checkedCheckableImageButtonId)).text as String
                Toast.makeText(activity, userMbti + "이시군요", Toast.LENGTH_SHORT).show()
                signUpMbti(userMbti)
            }
        }
        binding.startTestBtn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://www.16personalities.com/ko/")
            startActivity(i)
        }

        return binding.root
    }

    private fun signUpMbti(userMbti: String) {
        val authService = AuthService()
        authService.setSignUpView(this)
        authService.signUpMbti(getJwt(), getUser(userMbti))
    }

    private fun getUser(userMbti: String): User {
        val userIdx: Int = getUserIdx()
        val mbti: String = userMbti
        return User(userIdx = userIdx, mbti = mbti)
    }

    private fun getJwt(): String {
        val spf = requireActivity().getSharedPreferences("auth", Context.MODE_PRIVATE)
        return spf.getString("jwt", "")!!
    }

    private fun getUserIdx(): Int {
        val spf = requireActivity().getSharedPreferences("auth", Context.MODE_PRIVATE)
        return spf.getInt("userIdx", 0)
    }

    override fun onSignUpSuccess(code: Int, result: Result) {
        when(code) {
            1000 -> {
                Toast.makeText(activity, "mbti 입력에 성공하였습니다", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_mbtiFragment_to_finishFragment)
            }
        }
    }

    override fun onSignUpFailure(code: Int, message: String) {
        Log.d("OKOK/NICKNAME/FAILURE", message)
    }
}