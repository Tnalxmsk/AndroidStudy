package com.example.jetpackex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackex.R
import com.example.jetpackex.databinding.ActivityMainBinding
import com.example.jetpackex.viewModel.MainViewModel
import com.example.jetpackex.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    /*
        viewModelFactory = MainViewModelFactory(5000)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        with(binding) {
            mainCountTv.text = viewModel.countValue.toString()
            plusBt.setOnClickListener {
                viewModel.plus()
                mainCountTv.text = viewModel.countValue.toString()
            }
            minusBt.setOnClickListener {
                viewModel.minus()
                mainCountTv.text = viewModel.countValue.toString()
            }
            val manager = supportFragmentManager
            showFragmentBt.setOnClickListener {
                val transaction = manager.beginTransaction()
                val fragment = TestFragment()
                transaction.replace(R.id.frameArea, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

         */
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}