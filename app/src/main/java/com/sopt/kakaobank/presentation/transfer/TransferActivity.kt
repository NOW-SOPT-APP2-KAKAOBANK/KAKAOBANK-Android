package com.sopt.kakaobank.presentation.transfer

import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingActivity
import com.sopt.kakaobank.core.util.context.statusBarColorOf
import com.sopt.kakaobank.databinding.ActivityTransferBinding
import com.sopt.kakaobank.presentation.transfer.bottomsheet.TransferBottomSheet

class TransferActivity : BindingActivity<ActivityTransferBinding>(R.layout.activity_transfer) {
    override fun initView() {
        statusBarColorOf(R.color.white0)
        initTransferAdapter()
        initCloseBtnClickListener()
        initEnterBtnClickListener()
    }

    private fun initTransferAdapter() {
        binding.rvTransferRecentTransfer.adapter = TransferAdapter(click = { _, _ -> }).apply {
            submitList(
                listOf(
                    TransferEntity("김윤서", "농협 1234567890", false),
                    TransferEntity("박유진", "카카오뱅크 1234567890", false)
                )
            )
        }
        binding.rvTransferRecentTransfer.addItemDecoration(TransferItemDecorator(this))
    }

    private fun initCloseBtnClickListener() {
        binding.tvTransferAppbarClose.setOnClickListener {
            finish()
        }
    }

    private fun initEnterBtnClickListener() {
        binding.layoutTransferEnter.setOnClickListener {
            TransferBottomSheet().show(supportFragmentManager, TRANSFER_BOTTOM_SHEET)
        }
    }

    companion object {
        const val TRANSFER_BOTTOM_SHEET = "transfer_bottom_sheet"
    }
}