package com.example.datastorepractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.asLiveData
import com.example.datastorepractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var petManager: PetManager
    private var age : Int = 0
    private var name : String ="unKnown"
    private var isMale : Boolean = true
    private  var birth : String = "0000-00-00"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //applicationContext를 사용하면 DataStore가 액티비티의 생명주기에 종속되지 않고 앱 전체에서 안전하게 접근할 수 있습니다. MainActivity의 context를 사용할 경우, 액티비티가 재생성되거나 종료되었을 때 문제가 발생할 수 있기 때문에 피하는 것이 좋습니다.
        petManager = PetManager(dataStore)

        binding.run {
            btnSave()
            observeData()
        }
    }

    // 아래와 같은 방법으로 메소드를 정의하면 데이터바인딩을 써서 xml에서 정의된 뷰의 요소를 접근하는게 가능하다. 사용하지 않은 observeData() 를 살펴보면 바로 차이점을 알 수 있다.
    //btnSave를 binding을 써서 접근할 수 있냐 없냐의 차이다.
    private fun ActivityMainBinding.btnSave() {
        btnSave.setOnClickListener {
            age = etAge.text.toString().toInt()
            name = etName.text.toString()
            isMale = switchGender.isChecked
            birth = etBirth.text.toString()
            CoroutineScope(IO).launch {
                petManager.storePetInfo(age, name, isMale, birth)
            }

        }
    }

    private fun observeData(){
        petManager.petAgeFlow.asLiveData().observe(this){
            age = it ?: 0
            binding.tvAge.text = age.toString()
        }

        petManager.petBirthFlow.asLiveData().observe(this){
            birth = it ?: "19960301"
            binding.tvBirth.text = birth
        }

        petManager.petNameFlow.asLiveData().observe(this){
            name = it ?: "unKnown"
            binding.tvName.text = name.toString()
        }

        petManager.petGenderFlow.asLiveData().observe(this){
            isMale = it ?: true
            binding.tvGender.text = isMale.toString()
        }
    }
}