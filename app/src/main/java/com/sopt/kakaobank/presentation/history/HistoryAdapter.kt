package com.sopt.kakaobank.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.data.dto.response.History
import com.sopt.kakaobank.databinding.ItemHistoryDepositBinding
import com.sopt.kakaobank.databinding.ItemHistoryWithdrawBinding

class HistoryAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 임시의 빈 리스트
    private var historyList: List<History> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            // 입금
            TYPE_DEPOSIT -> {
                val binding = ItemHistoryDepositBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DepositViewHolder(binding)
            }
            // 출금
            TYPE_WITHDRAW -> {
                val binding = ItemHistoryWithdrawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                WithdrawViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val profile = historyList[position]

        when (holder) {
            is DepositViewHolder -> {
                holder.onBind(profile)
            }
            is WithdrawViewHolder -> {
                holder.onBind(profile)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            NUMBER_EVEN -> TYPE_DEPOSIT
            else -> TYPE_WITHDRAW
        }
    }

    fun setHistoryList(historyList: List<History>) {
        this.historyList = historyList.toList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = historyList.size

    companion object {
        const val NUMBER_EVEN = 0
        const val TYPE_DEPOSIT = 0
        const val TYPE_WITHDRAW = 1
    }
}