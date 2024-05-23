package com.sopt.kakaobank.presentation.history

import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.data.dto.response.History
import com.sopt.kakaobank.databinding.ItemHistoryDepositBinding
import com.sopt.kakaobank.databinding.ItemHistoryWithdrawBinding

// 입금
class DepositViewHolder(private val binding: ItemHistoryDepositBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: History) {
        binding.run {
            tvItemHistoryDepositDate.text = historyData.historyDate
            tvItemHistoryDepositName.text = historyData.historyName
            tvItemHistoryDepositSpent.text = "${historyData.historySpent}원"
            tvItemHistoryDepositBalance.text = historyData.historyBalance
        }
    }
}

// 출금
class WithdrawViewHolder(private val binding: ItemHistoryWithdrawBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: History) {
        binding.run {
            tvItemHistoryWithdrawDate.text = historyData.historyDate
            tvItemHistoryWithdrawName.text = historyData.historyName
            tvItemHistoryWithdrawSpent.text = "${historyData.historySpent}원"
            tvItemHistoryWithdrawBalance.text = historyData.historyBalance
        }
    }
}