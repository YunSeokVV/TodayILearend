package com.example.kakaoNavigationPractice

import android.app.Application
import com.kakaomobility.knsdk.KNSDK
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KNApplication : Application(){
    companion object {
        lateinit var knsdk : KNSDK
    }

    override fun onCreate() {
        super.onCreate()
        initalize()
        Logger.addLogAdapter(AndroidLogAdapter())
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