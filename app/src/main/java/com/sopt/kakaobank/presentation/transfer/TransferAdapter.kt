package com.sopt.kakaobank.presentation.transfer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sopt.kakaobank.core.view.ItemDiffCallback
import com.sopt.kakaobank.databinding.ItemTransferAccountBinding

class TransferAdapter(private val click: (Boolean, Int) -> Unit) :
    ListAdapter<Transfer, TransferViewHolder>(TransferAdapterDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder {
        val binding =
            ItemTransferAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransferViewHolder(binding, click)
    }

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        private val TransferAdapterDiffCallback =
            ItemDiffCallback<Transfer>(
                onItemsTheSame = { old, new -> old.name == new.name },
                onContentsTheSame = { old, new -> old == new },
            )
    }
}