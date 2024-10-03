package com.example.datastorepractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.datastorepractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var petManager: PetManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //applicationContext를 사용하면 DataStore가 액티비티의 생명주기에 종속되지 않고 앱 전체에서 안전하게 접근할 수 있습니다. MainActivity의 context를 사용할 경우, 액티비티가 재생성되거나 종료되었을 때 문제가 발생할 수 있기 때문에 피하는 것이 좋습니다.
        petManager = PetManager(dataStore)

    }
}