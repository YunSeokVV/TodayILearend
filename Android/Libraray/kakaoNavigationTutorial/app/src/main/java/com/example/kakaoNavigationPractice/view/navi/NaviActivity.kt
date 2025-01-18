package com.example.kakaoNavigationPractice.view.navi

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kakaoNavigationPractice.KNApplication
import com.example.kakaoNavigationPractice.R
import com.kakaomobility.knsdk.KNCarFuel
import com.kakaomobility.knsdk.KNCarType
import com.kakaomobility.knsdk.KNCarUsage
import com.kakaomobility.knsdk.KNRouteAvoidOption
import com.kakaomobility.knsdk.KNRoutePriority
import com.kakaomobility.knsdk.common.objects.KNError
import com.kakaomobility.knsdk.common.objects.KNPOI
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_CitsGuideDelegate
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_GuideStateDelegate
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_LocationGuideDelegate
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_RouteGuideDelegate
import com.kakaomobility.knsdk.guidance.knguidance.KNGuideRouteChangeReason
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_SafetyGuideDelegate
import com.kakaomobility.knsdk.guidance.knguidance.KNGuidance_VoiceGuideDelegate
import com.kakaomobility.knsdk.guidance.knguidance.citsguide.KNGuide_Cits
import com.kakaomobility.knsdk.guidance.knguidance.common.KNLocation
import com.kakaomobility.knsdk.guidance.knguidance.locationguide.KNGuide_Location
import com.kakaomobility.knsdk.guidance.knguidance.routeguide.KNGuide_Route
import com.kakaomobility.knsdk.guidance.knguidance.routeguide.objects.KNMultiRouteInfo
import com.kakaomobility.knsdk.guidance.knguidance.safetyguide.KNGuide_Safety
import com.kakaomobility.knsdk.guidance.knguidance.safetyguide.objects.KNSafety
import com.kakaomobility.knsdk.guidance.knguidance.voiceguide.KNGuide_Voice
import com.kakaomobility.knsdk.trip.knrouteconfiguration.KNRouteConfiguration
import com.kakaomobility.knsdk.trip.kntrip.KNTrip
import com.kakaomobility.knsdk.trip.kntrip.knroute.KNRoute
import com.kakaomobility.knsdk.ui.view.KNNaviView
import com.orhanobut.logger.Logger

class NaviActivity : AppCompatActivity(), KNGuidance_GuideStateDelegate,
    KNGuidance_LocationGuideDelegate, KNGuidance_SafetyGuideDelegate, KNGuidance_VoiceGuideDelegate, KNGuidance_CitsGuideDelegate,
    KNGuidance_RouteGuideDelegate {
    val TAG = "NaviActivity"
    lateinit var naviView :  KNNaviView

    override fun guidanceCheckingRouteChange(aGuidance: KNGuidance) {
        naviView.guidanceCheckingRouteChange(aGuidance)
    }

    override fun guidanceDidUpdateRoutes(aGuidance: KNGuidance, aRoutes: List<KNRoute>, aMultiRouteInfo: KNMultiRouteInfo?) {
        naviView.guidanceDidUpdateRoutes(aGuidance, aRoutes, aMultiRouteInfo)
    }

    override fun guidanceGuideEnded(aGuidance: KNGuidance) {
        naviView.guidanceGuideEnded(aGuidance)
    }

    override fun guidanceGuideStarted(aGuidance: KNGuidance) {
        naviView.guidanceGuideStarted(aGuidance)
    }

    override fun guidanceOutOfRoute(aGuidance: KNGuidance) {
        naviView.guidanceOutOfRoute(aGuidance)
    }

    override fun guidanceRouteChanged(
        aGuidance: KNGuidance,
        aFromRoute: KNRoute,
        aFromLocation: KNLocation,
        aToRoute: KNRoute,
        aToLocation: KNLocation,
        aChangeReason: KNGuideRouteChangeReason
    ) {
        naviView.guidanceRouteChanged(aGuidance)
    }

    // 이게 맞는건가?
//    override fun guidanceRouteChanged(aGuidance: KNGuidance) {
//        naviView.guidanceRouteChanged(aGuidance)
//    }

    override fun guidanceRouteUnchanged(aGuidance: KNGuidance) {
        naviView.guidanceRouteUnchanged(aGuidance)
    }

    override fun guidanceRouteUnchangedWithError(aGuidnace: KNGuidance, aError: KNError) {
        naviView.guidanceRouteUnchangedWithError(aGuidnace, aError)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)
        naviView = findViewById(R.id.navi_view)

        // status bar 영역까지 사용하기 위한 옵션
        window?.apply {
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        // 음량 설정하기 0 ~ 1 까지 조절 가능(Float임 0 ~ 100임)
        naviView.sndVolume = 1.0f

        // 차량에 대한 정보를 설정한다. 이 설정값에 따라서 주행 안내를 해주기 때문에 설정이 필요하다.
        // 부모님 차가 휘발유니까 그냥 가솔린으로 설정
        naviView.fuelType = KNCarFuel.KNCarFuel_Gasoline
        // 차량 기본 종류 설정
        naviView.carType = KNCarType.KNCarType_1

        requestRoute()
    }

    // 보다 정확한 안내를 위해서 차량의 종류,하이패스 장착 유무, 교통사고나 공사로 인한 도로 제한 등을 반여할지 설정한다.

    fun requestRoute() {
        // 예제 출처 : https://developers.kakaomobility.com/docs/android-ui/driving/

        // 1. 출발지 및 목적지 설정하기
        // 출발지 설정
        val start = KNPOI("현위치", 309840, 552483, "현위치")

        // 목적지 설정
        val goal = KNPOI("목적지", 321497, 532896, "목적지")

        // 2. 상세 정보 설정하기
        // 경로 생성
        KNApplication.knsdk.makeTripWithStart(start, goal, null, null){aError: KNError?, aTrip: KNTrip? ->
            val routeConfig = KNRouteConfiguration(
                aFuel = KNCarFuel.KNCarFuel_Gasoline,
                aUseHipass = true,                          // 하이패스 장착 여부
                //aUsage = true,                              //교통사고 또는 공사 등으로 인한 도로 통행 제한 정보(이하 유고 정보) 반영 여부
                aUsage = KNCarUsage.KNCarUsage_Default,
                aCarWidth = KNCarType.KNCarType_1.value,    // 차량의 종류
                aCarHeight = -1,
                aCarLength = -1,
                aCarWeight = -1,
            )

            aTrip?.setRouteConfig(routeConfig)

            // 3. 경로 옵션 설정하기
            //경로 안내 시 우선적으로 고려하는 항목(KNRoutePriority)과 경로 안내에서 회피하고 싶은 구간(KNRouteAvoidOption)을 선택합니다.
            // 시간을 우선시해서 설정
            val curRoutePriority = KNRoutePriority.KNRoutePriority_Time

            // 유고 정보 구간 회피(사고난곳 제외)
            val curAvoidOptions = KNRouteAvoidOption.KNRouteAvoidOption_RoadEvent.value

            // 길 안내하기
            //위에서 설정한 값들로 경로 요청후 안내시작. 경로 요청시 사용자가 직접 델리게이트를 설정할 수 있다. 입력한 델리게이트는 naviView로 반드시 전달되야함

            // 경로 요청하기
            aTrip?.routeWithPriority(curRoutePriority, curAvoidOptions){ error, _ ->
                if(error != null){
                    Logger.v("error code : "+error.code)
                    Logger.v("error message : "+error.msg.toString())
                } else {
                    Logger.v("load Complete")
                    // 경로 요청 성공
                    KNApplication.knsdk.sharedGuidance()?.apply {
                        // 각 가이던스 델리 게이트 등록
                        guideStateDelegate = this@NaviActivity
                        locationGuideDelegate = this@NaviActivity
                        routeGuideDelegate = this@NaviActivity
                        safetyGuideDelegate= this@NaviActivity
                        voiceGuideDelegate = this@NaviActivity
                        citsGuideDelegate = this@NaviActivity

                        naviView.initWithGuidance(
                            this,
                            aTrip,
                            curRoutePriority,
                            curAvoidOptions
                        )
                    }
                }
            }

        }
    }

    override fun guidanceDidUpdateLocation(
        aGuidance: KNGuidance,
        aLocationGuide: KNGuide_Location
    ) {
        naviView.guidanceDidUpdateLocation(aGuidance, aLocationGuide)
    }

    override fun guidanceDidUpdateAroundSafeties(
        aGuidance: KNGuidance,
        aSafeties: List<KNSafety>?
    ) {
        naviView.guidanceDidUpdateAroundSafeties(aGuidance, aSafeties)
    }

    // 경로 안내 정보 업데이트 시 호출. `routeGuide`의 항목이 1개 이상 변경 시 전달됨.
    override fun guidanceDidUpdateRouteGuide(guidance: KNGuidance, routeGuide: KNGuide_Route) {
        naviView.guidanceDidUpdateRouteGuide(guidance, routeGuide)
    }

    override fun guidanceDidUpdateSafetyGuide(
        aGuidance: KNGuidance,
        aSafetyGuide: KNGuide_Safety?
    ) {
        naviView.guidanceDidUpdateSafetyGuide(aGuidance, aSafetyGuide)
    }

    override fun didFinishPlayVoiceGuide(aGuidance: KNGuidance, aVoiceGuide: KNGuide_Voice) {
        naviView.didFinishPlayVoiceGuide(aGuidance, aVoiceGuide)
    }

    override fun shouldPlayVoiceGuide(
        aGuidance: KNGuidance,
        aVoiceGuide: KNGuide_Voice,
        aNewData: MutableList<ByteArray>
    ): Boolean {
        return naviView.shouldPlayVoiceGuide(aGuidance, aVoiceGuide, aNewData)
    }

    override fun willPlayVoiceGuide(aGuidance: KNGuidance, aVoiceGuide: KNGuide_Voice) {
        naviView.willPlayVoiceGuide(aGuidance, aVoiceGuide)
    }

    override fun didUpdateCitsGuide(aGuidance: KNGuidance, aCitsGuide: KNGuide_Cits) {
        naviView.didUpdateCitsGuide(aGuidance, aCitsGuide)
    }
}