package com.example.ascendion.ui.home

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ascendion.network.MarsApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var count = 0
    var _seconds  = MutableLiveData<Int> ()  //MutableLiveData  == observable
   // var seconds:Int = 0
    lateinit var timer:CountDownTimer

var TAG = HomeViewModel::class.java.simpleName
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


    val text: LiveData<String> = _text

    fun  incrementCount(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemaining: Long) {
                _seconds.value = timeRemaining.toInt()
                Log.i(TAG,"seconds remaining ="+_seconds)
            }

            override fun onFinish() {
                Log.i(TAG,"timer finished")
            }

        }.start()
    }
     fun getMarsPhotos() {
        viewModelScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            Log.i(TAG,listResult)
        }

    }

}