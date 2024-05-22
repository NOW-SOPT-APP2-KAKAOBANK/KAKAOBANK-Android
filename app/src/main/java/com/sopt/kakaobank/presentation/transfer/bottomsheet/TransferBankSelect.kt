package com.sopt.kakaobank.presentation.transfer.bottomsheet

import androidx.annotation.DrawableRes

data class TransferBankSelectTitle(
    val title: String,
    val content: List<TransferBankSelectContent>
)

data class TransferBankSelectContent(
    @DrawableRes val profile: Int,
    val name: String
)