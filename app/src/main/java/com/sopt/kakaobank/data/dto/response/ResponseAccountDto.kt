package com.sopt.kakaobank.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountDto(
    val accountName: String,
    val balance: Int,
    val accountId: Int
)
