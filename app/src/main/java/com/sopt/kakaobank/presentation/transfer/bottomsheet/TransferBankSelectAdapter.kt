package com.sopt.kakaobank.presentation.transfer.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sopt.kakaobank.core.view.ItemDiffCallback
import com.sopt.kakaobank.databinding.ItemTransferBankSelectBinding

class TransferBankSelectAdapter :
    ListAdapter<TransferBankSelectContentEntity, TransferBankSelectViewHolder>(
        TransferBankSelectAdapterDiffCallback
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransferBankSelectViewHolder {
        val binding =
            ItemTransferBankSelectBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TransferBankSelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransferBankSelectViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        private val TransferBankSelectAdapterDiffCallback =
            ItemDiffCallback<TransferBankSelectContentEntity>(
                onItemsTheSame = { old, new -> old.name == new.name },
                onContentsTheSame = { old, new -> old == new }
            )
    }
}
