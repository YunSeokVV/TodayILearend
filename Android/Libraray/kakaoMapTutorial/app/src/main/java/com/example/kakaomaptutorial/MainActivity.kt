package com.example.kakaomaptutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MapView.start() 를 호출하여 지도를 시작합니다. Activity 나 Fragment 의 onResume/onPause 시점에 맞춰 MapView.resume(), MapView.pause() 를 꼭 호출해줘야 합니다. 그렇지 않으면 지도의 라이프사이클에 문제가 생겨 알 수 없는 크래쉬가 발생 할 수 있습니다.
    }
}