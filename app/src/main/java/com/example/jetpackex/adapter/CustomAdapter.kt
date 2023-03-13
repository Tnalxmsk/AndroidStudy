package com.example.jetpackex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackex.databinding.MainrvItemBinding
import com.example.jetpackex.model.Post

class CustomAdapter(private val dataSet : ArrayList<Post>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: MainrvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.itemTv.text = post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val binding = MainrvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}