package com.example.fooddex.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fooddex.R
import com.example.fooddex.databinding.ActivityMainBinding
import com.example.fooddex.initalizer.LoggerInitalizer
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    //private val viewModel : MainViewModel
    internal val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoggerInitalizer.initalizerLogger()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //val button : Button = findViewById(R.id.button)
//        button.setOnClickListener{
//            Logger.v("gdgd")
//        }

    }



}