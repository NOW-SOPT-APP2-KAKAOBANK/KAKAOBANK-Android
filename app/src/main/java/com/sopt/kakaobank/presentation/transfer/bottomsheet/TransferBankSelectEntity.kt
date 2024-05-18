package com.sopt.kakaobank.presentation.transfer.bottomsheet

import androidx.annotation.DrawableRes

data class TransferBankSelectTitleEntity(
    val title: String,
    val content: List<TransferBankSelectContentEntity>
)

data class TransferBankSelectContentEntity(
    @DrawableRes val profile: Int,
    val name: String
)