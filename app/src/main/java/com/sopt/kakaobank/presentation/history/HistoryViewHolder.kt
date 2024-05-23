package com.sopt.kakaobank.presentation.history

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.core.util.context.initFormatAmount
import com.sopt.kakaobank.data.dto.response.ResponseMonthPayment
import com.sopt.kakaobank.databinding.ItemHistoryDepositBinding
import com.sopt.kakaobank.databinding.ItemHistoryWithdrawBinding

// 입금
class DepositViewHolder(private val binding: ItemHistoryDepositBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: ResponseMonthPayment.MonthlyTransfer) {
        binding.run {
            val transAmount = initFormatAmount(historyData.transferAmount)

            tvItemHistoryDepositDate.text = historyData.date
            tvItemHistoryDepositName.text = historyData.accountName
            tvItemHistoryDepositSpent.text = "${transAmount}원"

            if(historyData.hashTag != null)
            {
                tvItemHistoryDepositTag.isVisible = true
                tvItemHistoryDepositTag.text = "#${historyData.hashTag}"
            }
        }
    }
}

// 출금
class WithdrawViewHolder(private val binding: ItemHistoryWithdrawBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(historyData: ResponseMonthPayment.MonthlyTransfer) {
        binding.run {
            val transAmount = initFormatAmount(historyData.transferAmount)

            tvItemHistoryWithdrawDate.text = historyData.date
            tvItemHistoryWithdrawName.text = historyData.accountName
            tvItemHistoryWithdrawSpent.text = "${transAmount}원"

            if(historyData.hashTag != null)
            {
                tvItemHistoryWithdrawTag.isVisible = true
                tvItemHistoryWithdrawTag.text = "#${historyData.hashTag}"
            }
        }
    }
}