package com.example.jetpackex

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(num : Int) : ViewModel() {
    var countValue = 0

    init {
        Log.d("MainViewModel", num.toString())
    }
    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}