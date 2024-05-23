package com.sopt.kakaobank.data.dto.response

import com.sopt.kakaobank.presentation.transfer.Transfer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTransferRecentDto(
    @SerialName("accountName")
    val accountName: String,
    @SerialName("accountNumber")
    val accountNumber: Long,
    @SerialName("isAccountLike")
    val isAccountLike: Boolean,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("bankName")
    val bankName: String,
    @SerialName("imgUrl")
    val imgUrl: String,
    @SerialName("accountId")
    val accountId: Int,
) {
    fun toTransferEntity() = Transfer(
        accountId,
        imgUrl,
        accountName,
        bankName,
        accountNumber,
        isAccountLike,
    )
}
