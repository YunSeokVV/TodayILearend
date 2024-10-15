package com.example.kakaoNavigationPractice.view
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.kakaoNavigationPractice.BuildConfig
import com.example.kakaoNavigationPractice.KNApplication
import com.example.kakaoNavigationPractice.R
import com.kakaomobility.knsdk.KNLanguageType
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnGuide: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getKeyHash()

        btnGuide = findViewById(R.id.btn_guide)
        btnGuide.setOnClickListener(this)
    }

    fun getKeyHash() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val packageInfo = this.packageManager.getPackageInfo(this.packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            for (signature in packageInfo.signingInfo.apkContentsSigners) {
                try {
                    val md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    Logger.v("key hash: ${Base64.encodeToString(md.digest(), Base64.NO_WRAP)}")

                } catch (e: NoSuchAlgorithmException) {
                    //Logger.v("Unable to get MessageDigest. signature=$signature", e)
                }
            }
        }
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
                gpsPermissionCheck()
            }

            else -> {
                // 길찾기 SDK 인증
                knsdkAuth()
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
                aUserKey = BuildConfig.USER_KEY,                                                  // 사용자 id
                aLangType = KNLanguageType.KNLanguageType_KOREAN,   // 언어 타입
                aCompletion = {

                    // 토스트메세지는 ui갱신 작업이여서 UIThread에서 작업해야댐
                    runOnUiThread{
                        if(it != null){
                            Toast.makeText(applicationContext, "authenticationFailed",Toast.LENGTH_SHORT).show()
                            Logger.v("msg $it.msg")
                            Logger.v("msg ${it.code}")
                        } else{
                            Toast.makeText(applicationContext, "authenticationCompleted",Toast.LENGTH_SHORT).show()
                            var intent = Intent(this@MainActivity, NaviActivity::class.java)
                            this@MainActivity.startActivity(intent)
                        }
                    }
                }
            )
        }
    }
}
