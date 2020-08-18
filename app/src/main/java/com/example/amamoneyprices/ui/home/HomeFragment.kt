package com.example.amamoneyprices.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.amamoneyprices.R
import com.example.amamoneyprices.databinding.HomeFragmentBinding
import com.example.amamoneyprices.model.Currency
import com.example.amamoneyprices.model.Gold
import com.example.amamoneyprices.model.Item
import com.example.amamoneyprices.remote.errorhandeling.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.list.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.lastModified?.let { time ->
                        initModifyDate(time)
                    }
                    it.data?.currency?.let { money ->
                        initMoneyRecycle(money)
                    }

                    viewModel.hasError.value = false
                    viewModel.isShowLoading.value = false
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    viewModel.isShowLoading.value = false
                    viewModel.hasError.value = true
                }
                Status.LOADING -> {
                    viewModel.isShowLoading.value = true
                    viewModel.hasError.value = false
                }
            }

        })

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initModifyDate(lastModified: String) {
        binding.tvModifyDate.visibility = View.VISIBLE
        val newDate = lastModified.replace("+0100 BST", "")
        binding.tvModifyDate.text = getString(R.string.بروزرسانی) + newDate

    }

    private fun initMoneyRecycle(list : List<Currency>) {
        val adapter = MoneyPricesRecycleAdapter()
        adapter.submitList(list)
        binding.rvMoneyPrices.adapter = adapter
    }
}