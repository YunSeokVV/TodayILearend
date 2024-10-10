package com.example.kakaoNavigationPractice

import android.app.NativeActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kakaomobility.knsdk.KNLanguageType


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnGuide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGuide = findViewById(R.id.btn_guide)
        btnGuide.setOnClickListener(this)
    }

    // 버튼 클릭 이벤트
    override fun onClick(v: View?) {
        checkPermission()
    }

    // GPS 위치 권한을 확인
    fun checkPermission() {
        when {
            checkSelfPermission(
                //Manifest.permission.ACCESS_FINE_LOCATION
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED -> {
                // GPS 퍼미션 체크
            }

            else -> {
                // 길찾기 SDK 인증
            }
        }

    }

    /**
     * GPS 위치 권한을 요청합니다.
     */
    fun gpsPermissionCheck() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            1234)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            1234 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 다시 권한을 요청하는 곳으로 돌아간다
                    checkPermission()
                }
            }
        }
    }

    //길찾기 SDK 인증을 진행
    fun knsdkAuth() {
        KNApplication.knsdk.apply {
            initializeWithAppKey(
                aAppKey = BuildConfig.KAKAO_API_KEY,
                aClientVersion = "1.0.0",                                               // 현재 앱의 클라이언트 버전
                aUserKey = "testUser",                                                  // 사용자 id
                aLangType = KNLanguageType.KNLanguageType_KOREAN,   // 언어 타입
                aCompletion = {

                    // 토스트메세지는 ui갱신 작업이여서 UIThread에서 작업해야댐
                    runOnUiThread{
                        if(it != null){
                            Toast.makeText(applicationContext, "authenticationFailed",Toast.LENGTH_SHORT).show()
                        } else{
                            Toast.makeText(applicationContext, "authenticationCompleted",Toast.LENGTH_SHORT).show()
                            var intent = Intent(this@MainActivity, NativeActivity::class.java)
                            this@MainActivity.startActivity(intent)
                        }
                    }
                }
            )
        }
    }

}
