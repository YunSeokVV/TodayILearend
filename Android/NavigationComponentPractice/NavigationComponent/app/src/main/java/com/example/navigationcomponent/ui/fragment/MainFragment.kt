package com.example.navigationcomponent.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.R
import com.example.navigationcomponent.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding ?= null
    private val bindng : FragmentMainBinding
        get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)

        return bindng.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindng.apply {
            button.setOnClickListener {

                // 다른 예제를 보니 아래와 같은 예제도 가능하더라. 근데 지금 이 프로젝트에서는 navigation-safe-args 플러그인이 제대로 안적용되서 그런지 컴파일 에러가 발생한다.
                val action = MainFragmentDirections.actionMainFragmentToSecondFragment(editText.text.toString())
                val navigationController = findNavController()

                // 그냥 화면만 전환 (요런 방법도 있음)
                //navigationController.navigate(R.id.action_mainFragment_to_secondFragment)

                // 데이터 전달 및 화면전환
                navigationController.navigate(action)

            }
        }

    }
}