package com.example.fooddex.initalizer

import com.orhanobut.logger.AndroidLogAdapter
class LoggerInitalizer {
    companion object{
        fun initalizerLogger(){
            com.orhanobut.logger.Logger.addLogAdapter(AndroidLogAdapter())
        }
    }

}