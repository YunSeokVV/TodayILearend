package com.example.fooddex.ui.list

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.fooddex.R
import com.example.fooddex.initalizer.LoggerInitalizer
import com.example.fooddex.ui.list.
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoggerInitalizer.initalizerLogger()

        //val button : Button = findViewById(R.id.button)
//        button.setOnClickListener{
//            Logger.v("gdgd")
//        }

    }



}