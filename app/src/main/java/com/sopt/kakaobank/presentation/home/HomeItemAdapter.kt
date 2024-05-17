package com.sopt.kakaobank.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.databinding.ItemBankBook1Binding
import com.sopt.kakaobank.databinding.ItemBankBook2Binding
import com.sopt.kakaobank.databinding.ItemBankBook3Binding
import com.sopt.kakaobank.databinding.ItemCheckLimitBinding

class HomeItemAdapter(private val items: List<HomeItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeItem.CheckLimitItem -> VIEW_TYPE_CHECK_LIMIT
            is HomeItem.BankBookItem1 -> VIEW_TYPE_BANK_BOOK_1
            is HomeItem.BankBookItem2 -> VIEW_TYPE_BANK_BOOK_2
            is HomeItem.BankBookItem3 -> VIEW_TYPE_BANK_BOOK_3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_CHECK_LIMIT -> {
                val binding = ItemCheckLimitBinding.inflate(layoutInflater, parent, false)
                CheckLimitItemViewHolder(binding)
            }
            VIEW_TYPE_BANK_BOOK_1 -> {
                val binding = ItemBankBook1Binding.inflate(layoutInflater, parent, false)
                BankBookItem1ViewHolder(binding)
            }
            VIEW_TYPE_BANK_BOOK_2 -> {
                val binding = ItemBankBook2Binding.inflate(layoutInflater, parent, false)
                BankBookItem2ViewHolder(binding)
            }
            VIEW_TYPE_BANK_BOOK_3 -> {
                val binding = ItemBankBook3Binding.inflate(layoutInflater, parent, false)
                BankBookItem3ViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CheckLimitItemViewHolder -> holder.bind(items[position] as HomeItem.CheckLimitItem)
            is BankBookItem1ViewHolder -> holder.bind(items[position] as HomeItem.BankBookItem1)
            is BankBookItem2ViewHolder -> holder.bind(items[position] as HomeItem.BankBookItem2)
            is BankBookItem3ViewHolder -> holder.bind(items[position] as HomeItem.BankBookItem3)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CheckLimitItemViewHolder(private val binding: ItemCheckLimitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeItem.CheckLimitItem) {
            binding.tvScore1.text = item.name
        }
    }

    inner class BankBookItem1ViewHolder(private val binding: ItemBankBook1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeItem.BankBookItem1) {
            binding.tvBankBook1Name.text = item.name
        }
    }

    inner class BankBookItem2ViewHolder(private val binding: ItemBankBook2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeItem.BankBookItem2) {
            binding.tvBankBook2Name.text = item.name
        }
    }

    inner class BankBookItem3ViewHolder(private val binding: ItemBankBook3Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeItem.BankBookItem3) {
            binding.tvBankBook3Name.text = item.name
        }
    }

    companion object {
        private const val VIEW_TYPE_CHECK_LIMIT = 0
        private const val VIEW_TYPE_BANK_BOOK_1 = 1
        private const val VIEW_TYPE_BANK_BOOK_2 = 2
        private const val VIEW_TYPE_BANK_BOOK_3 = 3
    }
}