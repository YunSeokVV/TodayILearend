package com.example.kakaoNavigationPractice

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kakaomobility.knsdk.common.objects.KNPOI
import com.kakaomobility.knsdk.ui.view.KNNaviView

class NaviActivity : AppCompatActivity() {
    lateinit var naviView :  KNNaviView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)
        naviView = findViewById(R.id.navi_view)

        // status bar 영역까지 사용하기 위한 옵션
        window?.apply {
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }

    fun requestRoute() {
        Thread {
            // 출발지, 목적지 설정
            val startPoi = KNPOI("현위치", 309840, 552483, "현위치")
            val goalPoi = KNPOI("목적지", 321497, 532896, "목적지")

            KNApplication.knsdk.makeTripWithStart(
                aStart = startPoi,
                aGoal = goalPoi,
                aVias = null
            ) { aError, aTrip ->
                // 경로요청 성공시 aError는 null
                if (aError == null) {

                    }
                }
            }.start()
        }
    }