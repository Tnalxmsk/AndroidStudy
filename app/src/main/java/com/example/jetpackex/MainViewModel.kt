package com.example.jetpackex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue() {
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }

    /*
    var testMutableLiveData = MutableLiveData(0)

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