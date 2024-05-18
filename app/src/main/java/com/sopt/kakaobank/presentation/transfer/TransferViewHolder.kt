package com.sopt.kakaobank.presentation.transfer

import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.databinding.ItemTransferAccountBinding

class TransferViewHolder(
    private val binding: ItemTransferAccountBinding,
    private val click: (Boolean, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: TransferEntity) {
        with(binding) {
            tvItemTransferAccountName.text = data.name
            tvItemTransferAccountNumber.text = data.account
            ivItemTransferBookmark.setOnClickListener {
                data.bookmark = !data.bookmark
                ivItemTransferBookmark.setImageResource(if (data.bookmark) R.drawable.ic_transfer_bookmark_on else R.drawable.ic_transfer_bookmark_off)
                click(data.bookmark, adapterPosition)
            }
        }
    }
}
