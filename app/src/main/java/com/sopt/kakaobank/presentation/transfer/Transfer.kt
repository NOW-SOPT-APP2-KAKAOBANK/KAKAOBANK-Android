package com.sopt.kakaobank.presentation.transfer

data class Transfer(
    val id: Int,
    val profile: String,
    val accountName: String,
    val bankName: String,
    val accountNumber: Long,
    var bookmark: Boolean,
)