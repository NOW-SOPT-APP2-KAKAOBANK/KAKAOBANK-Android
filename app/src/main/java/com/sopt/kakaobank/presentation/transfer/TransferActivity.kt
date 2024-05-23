package com.sopt.kakaobank.presentation.transfer

import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingActivity
import com.sopt.kakaobank.core.util.context.statusBarColorOf
import com.sopt.kakaobank.core.view.UiState
import com.sopt.kakaobank.databinding.ActivityTransferBinding
import com.sopt.kakaobank.presentation.transfer.bottomsheet.TransferBottomSheet
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class TransferActivity : BindingActivity<ActivityTransferBinding>(R.layout.activity_transfer) {
    private val transferViewModel by viewModels<TransferViewModel>()

    override fun initView() {
        statusBarColorOf(R.color.white0)
        initGetRecentObserve()
        initCloseBtnClickListener()
        initEnterBtnClickListener()
    }

    private fun initGetRecentObserve() {
        transferViewModel.getTransferRecent.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> initTransferAdapter(it.data)
                is UiState.Failure -> Timber.d("실패 : $it")
                is UiState.Loading -> Timber.d("로딩중")
            }
        }.launchIn(lifecycleScope)
    }

    private fun onBookmarkClick(
        markedAccountId: Int,
        status: Boolean,
    ) {
        if (status) {
            // 코드 구현 : 윤서
        } else {
            transferViewModel.postTransferBookmark(markedAccountId)
        }
    }

    private fun initTransferAdapter(accountData: List<Transfer>) {
        binding.rvTransferRecentTransfer.adapter = TransferAdapter(
            onClickBookmarkBtn = ::onBookmarkClick,
        ).apply {
            submitList(accountData)
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