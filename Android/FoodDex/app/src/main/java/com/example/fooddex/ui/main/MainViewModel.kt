package com.example.fooddex.ui.main

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import com.example.fooddex.repository.MainActivityRepository
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainActivityRepository : MainActivityRepository
) : ViewModel() {

    init{
        checkData()
    }

    // todo : 원본 코드는 아래와 같다. 얘네도 코드를 보면 skydov가 만든 라이브러리다.
//    @get:Bindable
//    var isLoading: Boolean by bindingProperty(false)
//        private set
//
//    @get:Bindable
//    var toastMessage: String? by bindingProperty(null)
//        private set

    //@get:Bindable
    var isLoading : Boolean = false
    private set

    //@get:Bindable
    var toastMessage : String? = null
    private set

    // 결국 이 값 확인할 수 있어야함. 어케하는지 알아내보자.
    private val _pokemonFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val pokemonFetchingIndex : StateFlow<Int> = _pokemonFetchingIndex.asStateFlow()
    private val pokemonListFlow = _pokemonFetchingIndex.flatMapLatest { page ->
        mainActivityRepository.fetchPokemonList(
            page = page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it },
        )
    }

    private fun checkData(){
        pokemonFetchingIndex.value
        Logger.v("pokemonFetchingIndex.value "+pokemonFetchingIndex.value)
    }

    //asBindingProperty 이것도 skydovv 님의 라이브러리다.
//    @get:Bindable
//    val pokemonList :List<Pokemon> by pokemonListFlow.asBindingProp

}