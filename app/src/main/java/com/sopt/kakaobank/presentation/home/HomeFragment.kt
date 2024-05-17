package com.sopt.kakaobank.presentation.home

import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.databinding.FragmentHomeBinding
import com.sopt.kakaobank.presentation.history.HistoryFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = HomeItemAdapter(viewModel.homeItems)
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.homeRecyclerView.adapter = adapter

        val spaceInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 9f, resources.displayMetrics
        ).toInt()

        binding.homeRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                outRect.bottom = spaceInPixels
            }
        })
    }

    override fun initView() {
        // 로직 작성
    }

}