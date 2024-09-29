package com.example.navigationcomponent.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentSecondBinding
import com.example.navigationcomponent.databinding.FragmentThirdBinding


class ThirdFragmnet : Fragment() {
    private var _binding : FragmentThirdBinding ?= null
    private val binding : FragmentThirdBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_third, container, false)

        binding.apply {
            var receiveData = arguments?.getString("message2") ?: "두번째 화면에서 아무 데이터도 안보냄"
            textView5.text = receiveData
            if(receiveData == ""){
                receiveData = "두번째 화면에서 아무 데이터도 안보냄"
            }

            button.setOnClickListener {
                val action = ThirdFragmnetDirections.actionThirdFragmentToMainFragment()
                val navigationControlelr = findNavController()
                navigationControlelr.navigate(action)
            }
        }

        return binding.root
    }



}