package com.example.amamoneyprices.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amamoneyprices.databinding.GoldPriceItemsLayoutBinding
import com.example.amamoneyprices.model.Gold
import com.example.amamoneyprices.model.Item

class GoldPricesRecycleAdapter : ListAdapter <Item, GoldPricesRecycleAdapter.GoldViewHolder>(GoldDiffUtil()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GoldPriceItemsLayoutBinding.inflate(inflater,parent,false)
        return GoldViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoldViewHolder, position: Int) {
        holder.binding.item = getItem(position)
    }

    class GoldViewHolder(val binding: GoldPriceItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}

class GoldDiffUtil : DiffUtil.ItemCallback<Item>(){
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}