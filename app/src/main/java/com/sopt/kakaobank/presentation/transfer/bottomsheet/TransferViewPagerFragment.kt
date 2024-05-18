package com.sopt.kakaobank.presentation.transfer.bottomsheet

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.data.local.DummyTransferBankSelectList.data
import com.sopt.kakaobank.databinding.FragmentTransferBankSelectBinding
import com.sopt.kakaobank.presentation.transfer.TransferItemDecorator

class TransferViewPagerFragment :
    BindingFragment<FragmentTransferBankSelectBinding>(R.layout.fragment_transfer_bank_select) {
    override fun initView() {
        initTransferViewPagerAdapter()
    }

    private fun initTransferViewPagerAdapter() {
        binding.rvTransferBankSelect.adapter = TransferBankSelectAdapter().apply {
            submitList(
                data[arguments?.getInt(ARG_TYPE) ?: 0].content
            )
        }
        binding.rvTransferBankSelect.layoutManager = GridLayoutManager(context, 2)
        binding.rvTransferBankSelect.addItemDecoration(TransferBankSelectItemDecorator(requireContext()))
    }

    companion object {
        private const val ARG_TYPE = "type"

        fun newInstance(type: Int): TransferViewPagerFragment {
            val fragment = TransferViewPagerFragment()
            val args = Bundle()
            args.putInt(ARG_TYPE, type)
            fragment.arguments = args
            return fragment
        }
    }
}