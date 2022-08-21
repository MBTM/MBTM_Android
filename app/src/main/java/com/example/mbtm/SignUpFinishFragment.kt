package com.example.mbtm

import android.content.Intent
import android.os.Bundle
import com.example.mbtm.SignUpFinishFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mbtm.R
import com.example.mbtm.databinding.FragmentSignUpFinishBinding
import com.example.mbtm.databinding.FragmentSignUpFirstBinding
import com.example.mbtm.databinding.FragmentSignUpMbtiBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFinishFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SignUpFinishFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding: FragmentSignUpFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpFinishBinding.inflate(inflater, container, false)
        binding.signUpLoginBtn.setOnClickListener {
            val intent = Intent(getActivity(), LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signUpFinishGoToMainTv.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

}