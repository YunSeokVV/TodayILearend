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

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding ?= null
    private val binding : FragmentSecondBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)

        var receivedData = arguments?.getString("message") ?: "첫번째 화면에서 아무 데이터도 안보냄"
        if(receivedData == ""){
            receivedData = "첫번째 화면에서 아무 데이터도 안보냄"
        }

        binding.apply {
            textView5.text = receivedData
            button.setOnClickListener {
                val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(editText.text.toString())
                val navigationControlelr = findNavController()
                navigationControlelr.navigate(action)
            }
        }

        return binding.root
    }
}