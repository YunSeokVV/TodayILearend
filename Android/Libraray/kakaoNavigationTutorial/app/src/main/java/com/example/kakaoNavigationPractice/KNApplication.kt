package com.example.kakaoNavigationPractice

import android.app.Application
import com.kakaomobility.knsdk.KNSDK

class KNApplication : Application(){
    companion object {
        lateinit var knsdk : KNSDK
    }

    override fun onCreate() {
        super.onCreate()
        initalize()
    }

    /**
     *  길찾기 SDK의 초기화 및 파일이 저장될 경로를 설저
     */
    fun initalize(){
        knsdk = KNSDK.apply {
            //  파일 경로: data/data/com.kakaomobility.knsample/files/KNSample
            install(this@KNApplication, "$filesDir/KNSample")
        }
    }
}