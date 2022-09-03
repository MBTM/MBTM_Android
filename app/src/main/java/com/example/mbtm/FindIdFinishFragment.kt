package com.example.mbtm

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mbtm.databinding.FragmentFindIdFinishBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"


class FindIdFinishFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentFindIdFinishBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindIdFinishBinding.inflate(inflater, container, false)
        Log.d("Gabang/Finish", "finish")
        // Inflate the layout for this fragment

        binding.gotologinFinishidBtn.setOnClickListener {
            val intent = Intent(getActivity(), LoginActivity::class.java)
            startActivity(intent)
        }

        binding.resetpwFinishIdBtn.setOnClickListener {
            val intent = Intent(getActivity(), FindIdChangePwActivity::class.java)
            startActivity(intent)
        }

        return binding.root



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setUserId()


    }

    private fun setUserId() {
        val userId = getUserIdIdx()

        binding.realIdFinishidTv.visibility = View.VISIBLE
        binding.realIdFinishidTv.text = userId
    }


    fun getUserIdIdx():String {
        val spf = requireActivity().getSharedPreferences("auth", MODE_PRIVATE)
        return spf.getString("id", "")!!
    }



}