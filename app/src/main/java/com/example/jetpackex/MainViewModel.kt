package com.example.jetpackex
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord : LiveData<String>
        get() = _randomMutableWord

    val newData = Transformations.switchMap(liveWord) {
        getRandomWordShuffled(it)
    }

    init {
        getNextData()
    }

    fun getNextData() {
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)
    }

    fun getRandomWordShuffled(word: String) : MutableLiveData<String> {
        val liveData = MutableLiveData("")
        val randomTestWord = word.toCharArray()
        randomTestWord.shuffle()
        liveData.value = String(randomTestWord)
        return liveData
    }

    fun b() {
        viewModelScope.launch {
            for (i in 0..10) {
                delay(1000)
                Log.d("ViewModel", i.toString())
            }
        }
    }


    /*
    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue() {
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }

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