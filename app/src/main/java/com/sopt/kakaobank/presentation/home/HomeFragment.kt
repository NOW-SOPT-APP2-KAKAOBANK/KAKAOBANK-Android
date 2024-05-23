package com.sopt.kakaobank.presentation.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.databinding.FragmentHomeBinding
import com.sopt.kakaobank.presentation.history.HistoryFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun initView() {
        statusBarColorOf(R.color.dark_gray1)
        initHomeObserve()
    }

    private fun initHomeObserve() {
        viewModel.homeItems.observe(viewLifecycleOwner, Observer { homeItems ->
            initHomeItemAdapter(homeItems)
        })
    }

    private fun initHomeItemAdapter(homeItems: List<HomeItem>) {
        with(binding.rvHomeBox) {
            adapter = HomeItemAdapter(homeItems, this@HomeFragment)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(HomeRecyclerViewItemDecorator(requireContext()))
        }
    }

    fun navigateToHistory() {
        parentFragmentManager.beginTransaction().replace(R.id.cl_home_fragment, HistoryFragment())
            .addToBackStack(null).commit()
    }
}