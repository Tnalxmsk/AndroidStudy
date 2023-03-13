package com.example.jetpackex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.jetpackex.R
import com.example.jetpackex.databinding.FragmentTestBinding
import com.example.jetpackex.viewModel.MainViewModel

class TestFragment : Fragment() {
    private lateinit var binding : FragmentTestBinding
    private val viewModel : MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        /*
        with(binding) {
            fragmentTestTv.text = viewModel.getCount().toString()
        }

         */
        return binding.root
    }

}