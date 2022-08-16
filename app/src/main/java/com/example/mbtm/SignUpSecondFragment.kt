package com.example.mbtm

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mbtm.databinding.FragmentSignUpSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpSecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpSecondFragment : Fragment(), SignUpView {

    lateinit var binding: FragmentSignUpSecondBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.signUpNextBtn.setOnClickListener {
            signUpSecond()
        }
    }

    private fun signUpSecond() {
        if (binding.signUpNicknameEt.text.isEmpty()) {
            Toast.makeText(activity, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        val authService = AuthService()
        authService.setSignUpView(this)
        Log.d("OKOK/JWT", getJwt())
        authService.signUpSecond(getJwt(), getUser())
    }

    private fun getUser(): User {
        val userIdx: Int = getUserIdx()
        val nickName: String = binding.signUpNicknameEt.text.toString()
        return User(userIdx = userIdx, nickName = nickName)
    }

    private fun getJwt(): String {
        val spf = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
        return spf.getString("jwt", "")!!
    }

    private fun getUserIdx(): Int {
        val spf = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
        return spf.getInt("userIdx", 0)
    }


    override fun onSignUpSuccess(code: Int, result: Result) {
        when(code) {
            1000 -> {
                Toast.makeText(activity, "로그인 입력에 성공하였습니다", Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, StartMBTMActivity::class.java))
//                navController.navigate(R.id.action_secondFragment_to_mbtiFragment)
            }
        }
    }

    override fun onSignUpFailure(code: Int, message: String) {
        Log.d("OKOK/NICKNAME/FAILURE", message)
    }
}