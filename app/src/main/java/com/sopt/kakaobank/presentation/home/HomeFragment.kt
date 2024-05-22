package com.sopt.kakaobank.presentation.home

import android.graphics.Rect
import android.os.Bundle
import android.telephony.PhoneNumberUtils.formatNumber
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.databinding.FragmentHomeBinding
import com.sopt.kakaobank.databinding.ItemBankBook1Binding
import com.sopt.kakaobank.presentation.history.HistoryFragment
import java.text.NumberFormat
import java.util.Locale

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun initView() {
        statusBarColorOf(R.color.dark_gray1)
        initHomeItemAdapter()
    }

    private fun initHomeItemAdapter() {
        val formattedHomeItems = viewModel.homeItems.map { item ->
            when (item) {
                is HomeItem.BankBookItem3 -> {
                    val formattedWithdraw = formatNumber(item.withdraw)
                    item.copy(withdraw = formattedWithdraw)
                }
                else -> item
            }
        }.toMutableList()

        binding.rvHomeBox.adapter = HomeItemAdapter(formattedHomeItems, this)
        binding.rvHomeBox.layoutManager = LinearLayoutManager(context)

        binding.rvHomeBox.addItemDecoration(HomeRecyclerViewItemDecorator(requireContext()))
    }

    fun navigateToHistory() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.cl_home_fragment, HistoryFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun formatNumber(numberStr: String) : String {
        return numberStr.toIntOrNull()?.let {
            NumberFormat.getNumberInstance(Locale.US).format(it)
        } ?: numberStr
    }
}