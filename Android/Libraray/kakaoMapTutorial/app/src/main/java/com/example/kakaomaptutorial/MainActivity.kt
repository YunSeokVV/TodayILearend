package com.example.kakaomaptutorial
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapOverlay
import com.kakao.vectormap.MapType
import com.kakao.vectormap.MapView
import com.kakao.vectormap.MapViewInfo
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


class MainActivity : AppCompatActivity() {
    private lateinit var mapView : MapView
    private lateinit var kakaoMaps : KakaoMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())
        mapView = findViewById(R.id.map_view)

        // 지도 구성하기
        // MapView.start() 를 호출하여 지도를 시작합니다. Activity 나 Fragment 의 onResume/onPause 시점에 맞춰 MapView.resume(), MapView.pause() 를 꼭 호출해줘야 합니다. 그렇지 않으면 지도의 라이프사이클에 문제가 생겨 알 수 없는 크래쉬가 발생 할 수 있습니다.
        mapView.start(object : MapLifeCycleCallback() {
            override fun onMapDestroy() {
                TODO("Not yet implemented")
            }

            override fun onMapError(error : Exception?) {
                Logger.v("error "+error?.message)
            }

        }, object : KakaoMapReadyCallback() {
            override fun onMapReady(kakaoMap: KakaoMap) {
                // 인증 후 API 가 정상적으로 실행될 때 호출됨

                // 예제에서는 아래와 같은 방식으로 카카오맵을 초기화 했었다.
                // 예제 프로젝트 : https://apis.map.kakao.com/android_v2/sample/
                kakaoMaps = kakaoMap


                // 라벨 예제
                // https://apis.map.kakao.com/android_v2/docs/api-guide/label/
                kakaoMaps.labelManager

                // 1. LabelStyles 생성하기 - Icon 이미지 하나만 있는 스타일
                val styles = kakaoMaps.labelManager?.addLabelStyles(LabelStyles.from(LabelStyle.from(R.drawable.friends)))
                // 2. LabelOptions 생성하기
                val options = LabelOptions.from(LatLng.from(37.3377924, 127.1028461)).setStyles(styles)
                // 3. LabelLayer 가져오기 (또는 커스텀 Layer 생성)
                val layer = kakaoMaps.labelManager?.getLayer()
                // 4. LabelLayer 에 LabelOptions 을 넣어 Label 생성하기
                //val label = layer?.addLabel(options)


                // MapViewInfo 는 지도 시작 시에 KakaoMapReadyCallback 을 통해 설정 할 수 있습니다. 아래 코드는 지도 실행 중간에 MapViewInfo 를 변경하는 예제코드입니다.
                kakaoMaps.setOnMapViewInfoChangeListener(object :
                    KakaoMap.OnMapViewInfoChangeListener{
                    override fun onMapViewInfoChanged(mapViewInfo : MapViewInfo?) {
                        TODO("Not yet implemented")
                    }

                    override fun onMapViewInfoChangeFailed() {
                        TODO("Not yet implemented")
                    }

                })

                // 일반지도 타입으로 변환
                kakaoMaps.changeMapViewInfo(MapViewInfo.from("openmap", MapType.NORMAL))

                // 지도 오버레이
                // https://apis.map.kakao.com/android_v2/docs/getting-started/maptype_overlay/
                kakaoMaps.showOverlay(MapOverlay.HILLSHADING)   // 지형도
                //kakaoMaps.showOverlay(MapOverlay.BICYCLE_ROAD)   // 자전거도로

            }

            override fun getPosition(): LatLng {
                // 지도 시작시 위치 좌표를 설정
                return super.getPosition()
            }

            override fun getZoomLevel(): Int {
                // 지도 시작시 지도의 줌 정도를 설정
                return 15
                //return super.getZoomLevel()
            }

            override fun getViewName(): String {
                // kakaoMap 의 고유한 이름을 설정
                return super.getViewName()
            }

            override fun isVisible(): Boolean {
                // 지도 시작시 보일지말지 결정
                //return super.isVisible()
                return true
            }

            override fun getTag(): String {
                // KakaoMap 의 tag 을 설정 -> 이게뭐지?
                return "FirstMapTag"
            }
        })

    }

    override fun onResume() {
        super.onResume()
        mapView.resume()
    }

    override fun onPause() {
        super.onPause()
        mapView.pause();    // MapView 의 pause 호출

    }

}