package com.sopt.kakaobank.presentation.transfer.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingBottomSheetFragment
import com.sopt.kakaobank.data.local.DummyTransferBankSelectList.data
import com.sopt.kakaobank.databinding.BottomsheetTransferBankSelectBinding

class TransferBottomSheet :
    BindingBottomSheetFragment<BottomsheetTransferBankSelectBinding>(R.layout.bottomsheet_transfer_bank_select) {

    override fun initView() {
        initTransferViewPagerAdapter()
        initBottomSheetCloseClickListener()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme).apply {
            setOnShowListener { dialogInterface ->
                val bottomSheet =
                    (dialogInterface as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
                bottomSheet?.let { sheet ->
                    sheet.layoutParams.height = (resources.displayMetrics.heightPixels * 6 / 7)
                    sheet.requestLayout()
                }
            }
            behavior.state = BottomSheetBehavior.STATE_EXPANDED  // 하단 시트 확장된 상태
            behavior.skipCollapsed = true  // 하단 시트 축소 허용 x
        }
        return dialog
    }

    private fun initTransferViewPagerAdapter() {
        with(binding) {
            vpTransferBankSelect.adapter = TransferViewPagerAdapter(requireActivity())
            TabLayoutMediator(tabTransferBankSelect, vpTransferBankSelect) { tab, pos ->
                tab.text = data[pos].title
            }.attach()
        }
    }

    private fun initBottomSheetCloseClickListener() {
        binding.tvTransferBankSelectAppbarClose.setOnClickListener {
            dismiss()
        }
    }
}
