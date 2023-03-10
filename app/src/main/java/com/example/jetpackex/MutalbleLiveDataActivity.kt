package com.example.jetpackex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackex.databinding.ActivityMutalbleLiveDataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MutalbleLiveDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMutalbleLiveDataBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mutalble_live_data)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
        api.getPost1().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })

        api.getPostNumber(2).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API2", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API2", "fail")
            }

        })

        with(binding) {


            vm = viewModel
            lifecycleOwner = this@MutalbleLiveDataActivity
            liveBt.setOnClickListener {
                viewModel.getNextData()
            }


        //liveNumUpBt.setOnClickListener {
            //    viewModel.plusLiveDataValue()
        }
           // viewModel.testLiveData.observe(this@MutalbleLiveDataActivity) {
            //    liveNumTv.text = it.toString()
            //viewModel.testMutableLiveData.observe(this@MutalbleLiveDataActivity) {
            //    liveNumTv.text = it.toString()
    }
}