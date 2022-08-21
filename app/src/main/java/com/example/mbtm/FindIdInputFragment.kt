package com.example.mbtm

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mbtm.databinding.ActivityFindIdInputBinding
import com.example.mbtm.databinding.FragmentFindIdFinishBinding
import com.example.mbtm.databinding.FragmentFindIdInputBinding
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FindIdInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class FindIdInputFragment : Fragment(), FindIdView {

    lateinit var binding: FragmentFindIdInputBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindIdInputBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.firstFindIdInputBtn.setOnClickListener {
            findId()
        }
    }

    // 이메일 가져오기
    private fun getUser(): User{
        val nickName: String = binding.nicknameInputEt.text.toString()
        val email : String = binding.loginEmailInputEt.text.toString()

        return User(nickName = nickName, email = email)
    }

    // 입력되지 않거나 확인되지 않으면 회원가입 진행되지 않게 만들기
    // 네비 컨트롤러 sharedpreference

    private fun saveUserIdIdx(id: String, userIdx: Int) {
        val spf: SharedPreferences = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
        val editor = spf.edit()
        editor.putString("id", id)
        editor.putInt("userIdx", userIdx)
        editor.apply()
    }

    private fun findId() {
//        if (binding.loginEmailInputEt.text.toString().isEmpty() && binding.nicknameInputEt.text.toString().isEmpty()){
//            binding.findIdNicknameErrorTv.visibility = View.VISIBLE
//            binding.findIdEmailErrorTv.visibility = View.VISIBLE
//        }
        if (binding.nicknameInputEt.text.toString().isEmpty()) {
            Toast.makeText(activity, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
//            binding.findIdNicknameErrorTv.visibility = View.GONE
            return
        }
        else if (binding.loginEmailInputEt.text.toString().isEmpty()) {
            Toast.makeText(activity, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
//            binding.findIdNicknameErrorTv.visibility = View.GONE
            return
        }

        val authService = AuthService()
        authService.setFindIdView(this)

        authService.findId(getUser())

        Log.d("SIGNUP-ACT/ASYNC", "Hello, FLO")

    }
    override fun onFindIdSuccess(code: Int, result: Result) {

        // 아이디 넘기기
        // intent.putExtra("아이디 값", EditText1.text.toString())

        Log.d("SIGNUP-ACT/ASYNC", "Find Success")

        when(code) {
            1000 ->{
                saveUserIdIdx(result.id, result.userIdx)
                Toast.makeText(activity, "아이디 찾기 성공", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_firstFragment_to_finishFragment)
                Log.d("FindId", result.id)
                Log.d("FindId", result.userIdx.toString())

            }
        }
        //finish()

//        navController.navigate(R.id.action_firstFragment_to_secondFragment)


    }

    override fun onFindIdFailure(code: Int, message: String) {

        binding.findIdEmailErrorTv.visibility = View.GONE
        binding.findIdNicknameErrorTv.visibility = View.GONE

            when (code) {
                2039->{
                    binding.findIdNicknameErrorTv.visibility = View.VISIBLE
                    binding.findIdNicknameErrorTv.text = message
                }
                2034 -> {
                    // 실패시 나오는것도 나오도록 하기
                    this.binding.findIdEmailErrorTv.visibility = View.VISIBLE
                    this.binding.findIdEmailErrorTv.text = message
                }
            }

    }



}


