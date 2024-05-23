package com.sopt.kakaobank.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountDto(
    @SerialName("accountName")
    val accountName: String,
    @SerialName("balance")
    val balance: Int,
    @SerialName("accountId")
    val accountId: Int
)
