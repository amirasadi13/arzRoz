package com.example.amamoneyprices.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.amamoneyprices.databinding.MoneyPriceItemsLayoutBinding
import com.example.amamoneyprices.model.Currency

class MoneyPricesRecycleAdapter : ListAdapter<Currency,MoneyPricesRecycleAdapter.MyViewHolder>(MyDifUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoneyPriceItemsLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.item = getItem(position)
    }


    class MyViewHolder(val binding : MoneyPriceItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}

class MyDifUtil : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return newItem.code == oldItem.code
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return newItem == oldItem
    }
}