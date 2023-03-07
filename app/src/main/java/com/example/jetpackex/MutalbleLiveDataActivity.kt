package com.example.jetpackex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackex.databinding.ActivityMutalbleLiveDataBinding

class MutalbleLiveDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMutalbleLiveDataBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mutalble_live_data)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

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