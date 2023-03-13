package com.example.jetpackex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackex.R
import com.example.jetpackex.adapter.CustomAdapter
import com.example.jetpackex.api.MyApi
import com.example.jetpackex.api.RetrofitInstance
import com.example.jetpackex.databinding.ActivityMutalbleLiveDataBinding
import com.example.jetpackex.model.Post
import com.example.jetpackex.viewModel.MainViewModel
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
        with(viewModel) {
            getPost1()
            getPostNumber(3)
            getPostNumber(5)
            getPostAll()
            liveWord1.observe(this@MutalbleLiveDataActivity) {
                binding.liveNumTv1.text = it.toString()
            }
            liveWord2.observe(this@MutalbleLiveDataActivity) {
                binding.liveNumTv2.text = it.toString()
            }

            liveWordList.observe(this@MutalbleLiveDataActivity) {
                val customAdapter = CustomAdapter(it as ArrayList<Post>)
                binding.mainRv.adapter = customAdapter
                binding.mainRv.layoutManager = LinearLayoutManager(this@MutalbleLiveDataActivity)
            }
        }

    /*
        val api = RetrofitInstance.getInstance().create(MyApi::class.java)

        // 1. 유저 정보를 가져와서 (userId)
        api.getPost1().enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
                // 2. userId 기반으로 데이터를 가져오고 가져온 닉네임값
                api.getPostNumber(2).enqueue(object : Callback<Post> {
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        Log.d("API2", response.body().toString())
                        // 3. 닉네임 기반으로 데이터를 가져오고 유저의 댓글을 가져와서
                        api.getPostNumber(3).enqueue(object : Callback<Post> {
                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                Log.d("API3", response.body().toString())
                                // 4. 유저의 댓글 기반으로, 대댓글
                                api.getPostNumber(4).enqueue(object : Callback<Post> {
                                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                        Log.d("API4", response.body().toString())
                                    }

                                    override fun onFailure(call: Call<Post>, t: Throwable) {
                                        Log.d("API4", "fail")
                                    }

                                })
                            }

                            override fun onFailure(call: Call<Post>, t: Throwable) {
                                Log.d("API3", "fail")
                            }

                        })
                    }

                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.d("API2", "fail")
                    }

                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })

        with(binding) {
            vm = viewModel
            lifecycleOwner = this@MutalbleLiveDataActivity
            liveBt.setOnClickListener {
                viewModel.getNextData()
            }
            // ViewModelScope 사용
            viewModel.b()

         */
        //liveNumUpBt.setOnClickListener {
            //    viewModel.plusLiveDataValue()
           // viewModel.testLiveData.observe(this@MutalbleLiveDataActivity) {
            //    liveNumTv.text = it.toString()
            //viewModel.testMutableLiveData.observe(this@MutalbleLiveDataActivity) {
            //    liveNumTv.text = it.toString()
    }
}