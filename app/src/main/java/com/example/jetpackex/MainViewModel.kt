package com.example.jetpackex

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var testMutableLiveData = MutableLiveData(0)

    fun plusLiveDataValue() {
        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }

    /*
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

     */
}