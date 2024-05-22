package com.sopt.kakaobank.presentation.transfer.bottomsheet

import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.databinding.ItemTransferBankSelectBinding

class TransferBankSelectViewHolder(private val binding: ItemTransferBankSelectBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: TransferBankSelectContent) {
        with(binding) {
            ivItemTransferBankSelect.setImageResource(data.profile)
            tvItemTransferBankSelect.text = data.name
        }
    }
}
