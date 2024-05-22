package com.sopt.kakaobank.presentation.history

import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.data.dto.response.History
import com.sopt.kakaobank.databinding.ItemHistoryDepositBinding
import com.sopt.kakaobank.databinding.ItemHistoryWithdrawBinding

// 입금
class DepositViewHolder(private val binding: ItemHistoryDepositBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: History) {
        binding.run {
            tvHistoryDate.text = historyData.historyDate
            tvHistoryName.text = historyData.historyName
            tvHistorySpent.text = "${historyData.historySpent}원"
            tvHistoryBalance.text = historyData.historyBalance
        }
    }
}

// 출금
class WithdrawViewHolder(private val binding: ItemHistoryWithdrawBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: History) {
        binding.run {
            tvHistoryDate.text = historyData.historyDate
            tvHistoryName.text = historyData.historyName
            tvHistorySpent.text = "${historyData.historySpent}원"
            tvHistoryBalance.text = historyData.historyBalance
        }
    }
}