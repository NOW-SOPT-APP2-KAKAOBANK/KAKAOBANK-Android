package com.sopt.kakaobank.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAccountInfo(
    @SerialName("accountName")
    val accountName: String,
    @SerialName("balance")
    val balance: Long,
    @SerialName("accountNumber")
    val accountNumber: Long
)