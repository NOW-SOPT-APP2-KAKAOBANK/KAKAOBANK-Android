package com.sopt.kakaobank.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.core.view.ItemDiffCallback
import com.sopt.kakaobank.data.dto.response.ResponseMonthPaymentDto
import com.sopt.kakaobank.databinding.ItemHistoryDepositBinding
import com.sopt.kakaobank.databinding.ItemHistoryWithdrawBinding

class HistoryAdapter : ListAdapter<ResponseMonthPaymentDto.MonthlyTransfer, RecyclerView.ViewHolder>(HistoryAdapterDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DEPOSIT -> ItemHistoryDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).let { DepositViewHolder(it) }
            TYPE_WITHDRAW -> ItemHistoryWithdrawBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).let { WithdrawViewHolder(it) }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val profile = getItem(position)

        when (holder) {
            is DepositViewHolder -> holder.onBind(profile)
            is WithdrawViewHolder -> holder.onBind(profile)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            NUMBER_EVEN -> TYPE_DEPOSIT
            else -> TYPE_WITHDRAW
        }
    }

    companion object {
        const val NUMBER_EVEN = 0
        const val TYPE_DEPOSIT = 0
        const val TYPE_WITHDRAW = 1

        private val HistoryAdapterDiffCallback = ItemDiffCallback<ResponseMonthPaymentDto.MonthlyTransfer>(
            onItemsTheSame = { old, new -> old.accountName == new.accountName },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}