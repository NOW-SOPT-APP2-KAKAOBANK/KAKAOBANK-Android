package com.sopt.kakaobank.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMonthPayment(
    @SerialName("payment")
    val payment: Long,
    @SerialName("isTotalOverZero")
    val isTotalOverZero: Boolean,
    @SerialName("monthlyTransferList")
    val monthlyTransferList: List<MonthlyTransfer>
){
    @Serializable
    data class MonthlyTransfer(
        @SerialName("accountName")
        val accountName: String,
        @SerialName("date")
        val date: String,
        @SerialName("transferAmount")
        val transferAmount: Long,
        @SerialName("balance")
        val balance: Long,
        @SerialName("isWithdraw")
        val isWithdraw: Boolean,
        @SerialName("hashTag")
        val hashTag: String?
    )
}