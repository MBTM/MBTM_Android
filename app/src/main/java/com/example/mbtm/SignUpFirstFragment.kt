package com.example.mbtm

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mbtm.databinding.FragmentSignUpFirstBinding
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFirstFragment : Fragment(), SignUpView {

    lateinit var binding: FragmentSignUpFirstBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSignUpFirstBinding.inflate(inflater, container, false)

//        binding.signUpNextBtn.setOnClickListener {
//            Toast.makeText(activity, "회원가입", Toast.LENGTH_SHORT).show()
//            Log.d("OKOK/CALL-SIGNUP", "hello")
//            signUp()
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.signUpNextBtn.setOnClickListener {
            signUp()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUpFirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getUser(): User {
        val id: String = binding.signUpIdEt.text.toString()
        val pwd: String = binding.signUpPasswordEt.text.toString()
        val pwdCheck: String = binding.signUpPasswordConfirmEt.text.toString()
        val email: String = binding.signUpEmailEt.text.toString()
        val phone: String = binding.signUpPhoneEt.text.toString()

        return User(id = id, password = pwd, passwordCheck = pwdCheck, email = email, phone = phone)

    }

    private fun signUp() {
        if (binding.signUpIdEt.text.toString().isEmpty()) {
            Toast.makeText(activity, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        } else if (binding.signUpPasswordEt.text.isEmpty()) {
            Toast.makeText(activity, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        } else if (binding.signUpPasswordConfirmEt.text.isEmpty()) {
            Toast.makeText(activity, "확인용 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        } else if (binding.signUpEmailEt.text.isEmpty()) {
            Toast.makeText(activity, "이메일 주소를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        } else if (binding.signUpPhoneEt.text.isEmpty()) {
            Toast.makeText(activity, "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

//        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
//        authService.signUp(getUser()).enqueue(object : Callback<AuthResponse> {
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                Log.d("OKOK/SIGNUP/SUCCESS", response.toString())
//                val resp: AuthResponse = response.body()!!
//                Log.d("OKOK/SIGNUP/CODE", resp.code.toString())
//                when (resp.code) {
//                    1000 -> {
////                        isSuccess = true
//                        Toast.makeText(activity, "회원 가입에 성공하였습니다", Toast.LENGTH_SHORT).show()
//                        navController.navigate(R.id.action_firstFragment_to_secondFragment)
//                    }
//
//                    2032 -> {
//
//                    }
//
//                }
//            }
//
//            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                Log.d("OKOK/SIGNUP/FAILURE", t.message.toString())
//            }
//
//        })
//        Log.d("OKOK/SIGNUP/FINISH", "SignUp Finish")


        val authService = AuthService()
        authService.setSignUpView(this)
        authService.signUp(getUser())
    }

    override fun onSignUpSuccess(code: Int, result: Result) {
        when (code) {
            1000 -> {
                saveJwt(result.jwt)
                Toast.makeText(activity, "회원 가입에 성공하였습니다", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_firstFragment_to_secondFragment)
                Log.d("OKOK/SIGNUP/JWT", result.jwt)
                Log.d("OKOK/SIGNUP/JWT", result.userIdx.toString())
            }
        }

    }

    private fun saveJwt(jwt: String) {
        val spf: SharedPreferences = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
        val editor = spf.edit()
        editor.putString("jwt", jwt)
        editor.apply()

    }

    override fun onSignUpFailure(code: Int, message: String) {

        binding.signUpIdErrorTv.visibility = View.GONE
        binding.signUpPasswordCheckErrorTv.visibility = View.GONE
        binding.signUpEmailErrorTv.visibility = View.GONE
        binding.signUpPhoneErrorTv.visibility = View.GONE

        when (code) {
            2036 -> {
                binding.signUpIdErrorTv.visibility = View.VISIBLE
                binding.signUpIdErrorTv.text = message
            }
            2032 -> {
                binding.signUpPasswordCheckErrorTv.visibility = View.VISIBLE
                binding.signUpPasswordCheckErrorTv.text = message
            }
            2034, 2038 -> {
                binding.signUpEmailErrorTv.visibility = View.VISIBLE
                binding.signUpEmailErrorTv.text = message
            }
            2035 -> {
                binding.signUpPhoneErrorTv.visibility = View.VISIBLE
                binding.signUpPhoneErrorTv.text = message
            }
            else -> Toast.makeText(activity, "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show()

        }
    }
}