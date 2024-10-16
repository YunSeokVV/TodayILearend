package com.example.kakaoNavigationPractice.view.navi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NaviViewModel @Inject constructor() : ViewModel(){
    private var _searchLoadLiveData = MutableLiveData<Any>()
    val searchLoadLiveData : LiveData<Any>
        get() {
            return _searchLoadLiveData
        }




}