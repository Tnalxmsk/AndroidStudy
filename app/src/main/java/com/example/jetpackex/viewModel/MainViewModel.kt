package com.example.jetpackex.viewModel
import android.util.Log
import androidx.lifecycle.*
import com.example.jetpackex.api.MyApi
import com.example.jetpackex.api.RetrofitInstance
import com.example.jetpackex.model.Post
import com.example.jetpackex.testDataList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.create

class MainViewModel() : ViewModel() {
    private  val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    private var _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>
        get() = _mutableWordList

    fun getPost1() = viewModelScope.launch {
        val post = retrofitInstance.getPost1()
        Log.d("MainViewModel", post.toString())
        _mutableWord1.value = post.title
    }

    fun getPostNumber(number: Int) = viewModelScope.launch {
        val post = retrofitInstance.getPostNumber(number)
        Log.d("MainViewModel", post.toString())
        _mutableWord2.value = post.title
    }

    fun getPostAll() = viewModelScope.launch {
        val postAll = retrofitInstance.getPostAll()
        Log.d("MainViewModel", postAll.toString())
        _mutableWordList.value = postAll
    }

    /*
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