package com.example.amamoneyprices.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.amamoneyprices.databinding.CoinPriceItemsLayoutBinding
import com.example.amamoneyprices.model.Gold
import com.example.amamoneyprices.model.Item

class CoinPricesRecycleAdapter : ListAdapter<Gold, CoinPricesRecycleAdapter.CoinViewHolder>(CoinDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CoinPriceItemsLayoutBinding.inflate(inflater,parent,false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.binding.item = getItem(position)
    }

    class CoinViewHolder(val binding: CoinPriceItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root)


}

class CoinDiffUtil : DiffUtil.ItemCallback<Gold>(){
    override fun areItemsTheSame(oldItem: Gold, newItem: Gold): Boolean {
        return oldItem.coin == newItem.coin
    }

    override fun areContentsTheSame(oldItem: Gold, newItem: Gold): Boolean {
        return oldItem == newItem
    }

}