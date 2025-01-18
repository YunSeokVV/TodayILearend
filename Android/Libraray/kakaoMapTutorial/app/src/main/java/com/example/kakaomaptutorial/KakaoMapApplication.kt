package com.example.kakaomaptutorial

import android.app.Application
import com.kakao.vectormap.KakaoMapSdk

class KakaoMapApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoMapSdk.init(this, BuildConfig.KAKAO_MAP_API_KEY)
    }
}