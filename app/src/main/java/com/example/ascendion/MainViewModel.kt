package com.example.ascendion

import androidx.lifecycle.ViewModel
//class MainViewModel extends ViewModel{}


class MainViewModel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }

}