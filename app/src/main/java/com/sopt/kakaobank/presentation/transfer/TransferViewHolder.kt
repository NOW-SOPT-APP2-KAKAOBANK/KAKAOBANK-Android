package com.sopt.kakaobank.presentation.transfer

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.kakaobank.R
import com.sopt.kakaobank.databinding.ItemTransferAccountBinding

class TransferViewHolder(
    private val binding: ItemTransferAccountBinding,
    private val onClickBookmarkBtn: (Int, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Transfer) {
        with(binding) {
            Glide.with(root.context).load(data.profile).centerCrop().into(ivItemTransferAccount)
            tvItemTransferAccountName.text = data.accountName
            tvItemTransferAccountNumber.text = "${data.accountName} ${data.accountNumber}"
            ivItemTransferBookmark.setImageResource(if (data.bookmark) R.drawable.ic_transfer_bookmark_on else R.drawable.ic_transfer_bookmark_off)
            initBookmarkBtnClickListener(data)
        }
    }

    private fun initBookmarkBtnClickListener(data: Transfer) {
        with(binding) {
            ivItemTransferBookmark.setOnClickListener {
                onClickBookmarkBtn(data.id, ivItemTransferBookmark.isSelected)
                data.bookmark = !ivItemTransferBookmark.isSelected
                ivItemTransferBookmark.isSelected = !ivItemTransferBookmark.isSelected
                ivItemTransferBookmark.setImageResource(if (data.bookmark) R.drawable.ic_transfer_bookmark_on else R.drawable.ic_transfer_bookmark_off)
            }
        }
    }
}
