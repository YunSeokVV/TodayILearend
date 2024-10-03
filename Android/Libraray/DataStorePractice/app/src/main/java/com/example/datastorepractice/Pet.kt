package com.example.datastorepractice
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

// 아래 코드는 코틀린의 확장함수와 비슷한 확장 프로퍼티라고 하는 개념이다.
//Context에 dataStore라고 하는 프로퍼티(자바에서 얘기하는 그 속성을 의미한다)를 만들어준다. 이는 activity, fragment, Service 등 사용이 가능하다. (context를 쓰는 곳에선 어디서든 쓸 수 있는듯.)
//그리고 by 키워드를 활용해서 dataStore프로퍼티는 preferenceDataStore로 부터 위임을 받아서 자동으로 관리된다.
//요약 : 간단하게 Context에서 데이터 저장소에 접근할 수 있도록 하기 위해 확장 프로퍼티를 사용한 것이다.
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "pet_prefs")

// hilt같은 의존성 주입 라이브러리를 쓰는 방법도 있을텐데 왜 dataStore는 이렇게 되어있을까?
//Hilt나 다른 의존성 주입(DI) 라이브러리도 DataStore를 주입하는 데 사용할 수 있지만, DataStore는 상대적으로 가볍고 자주 사용되는 기능입니다. 확장 프로퍼티로 제공함으로써:
//간결성: Context에 직접 dataStore를 확장 프로퍼티로 추가하여 간단하게 접근할 수 있습니다.
//사용 편의성: 의존성 주입을 설정하는 것보다 더 간편하게 Context에서 바로 사용할 수 있어 코드가 짧고 명확해집니다.
//범용성: 모든 Context (즉, Activity, Application, Service 등)에서 동일한 방식으로 접근할 수 있어 재사용성이 높습니다.