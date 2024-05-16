package com.sopt.kakaobank.presentation.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.databinding.FragmentHomeBinding

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var adapter: HomeItemAdapter

    override fun initView() {
        // 로직 작성
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)

        val items = listOf(
            HomeItem.CheckLimitItem("김미정님의 신용점수는"),
            HomeItem.BankBookItem1("햄들의 통장"),
            HomeItem.BankBookItem2("햄통장"),
            HomeItem.BankBookItem3("김미정의 통장")
        )

        adapter = HomeItemAdapter(items)
        binding.homeRecyclerView.adapter = adapter
    }

}