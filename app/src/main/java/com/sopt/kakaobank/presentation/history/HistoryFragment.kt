package com.sopt.kakaobank.presentation.history

import android.content.Intent
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.databinding.FragmentHistoryBinding
import com.sopt.kakaobank.presentation.transfer.TransferActivity
import java.text.DecimalFormat

class HistoryFragment : BindingFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    override fun initView() {
        statusBarColorOf(R.color.main) //status 색상 변경
        initBackBtnClickListener()
        initHistoryAdapter()
        initTransferBtnClickListener()
    }

    // 뒤로 가기
    private fun initBackBtnClickListener() {
        binding.ibHistoryBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    // 이체하기
    private fun initTransferBtnClickListener() {
        binding.tvHistoryTransfer.setOnClickListener {
            startActivity(Intent(requireContext(), TransferActivity::class.java))
        }
    }

    // 1000원 단위 콤마
    private fun initFormatAmount(amount : Int): String {
        val dec = DecimalFormat("#,###")
        return dec.format(amount)
    }

    private fun initHistoryAdapter() {
        binding.rvHistoryUsage.adapter = HistoryAdapter()
        binding.rvHistoryUsage.layoutManager = LinearLayoutManager(requireContext())
    }
}