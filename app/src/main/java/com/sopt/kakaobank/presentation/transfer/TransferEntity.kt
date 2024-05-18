package com.sopt.kakaobank.presentation.transfer

data class TransferEntity(
    val name: String,
    val account: String,
    var bookmark: Boolean,
)