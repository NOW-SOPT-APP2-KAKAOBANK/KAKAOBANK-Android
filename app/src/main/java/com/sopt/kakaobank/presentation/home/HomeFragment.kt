package com.sopt.kakaobank.presentation.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.databinding.FragmentHomeBinding
import com.sopt.kakaobank.presentation.history.HistoryFragment
import java.text.NumberFormat
import java.util.Locale

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun initView() {
        statusBarColorOf(R.color.dark_gray1)
        initHomeItemAdapter()
        viewModel.getHomeItems()
        observeHomeItems()
    }

    private fun initHomeItemAdapter() {
        binding.rvHomeBox.layoutManager = LinearLayoutManager(context)
        binding.rvHomeBox.addItemDecoration(HomeRecyclerViewItemDecorator(requireContext()))
    }

    private fun observeHomeItems() {
        viewModel.homeItems.observe(viewLifecycleOwner, Observer { homeItems ->
            homeItems?.let {
                binding.rvHomeBox.adapter = HomeItemAdapter(it, this)
            }
        })
    }

    fun navigateToHistory() {
        parentFragmentManager.beginTransaction().replace(R.id.cl_home_fragment, HistoryFragment())
            .addToBackStack(null).commit()
    }

    private fun formatNumber(numberStr: String): String {
        return numberStr.toIntOrNull()?.let {
            NumberFormat.getNumberInstance(Locale.US).format(it)
        } ?: numberStr
    }
}