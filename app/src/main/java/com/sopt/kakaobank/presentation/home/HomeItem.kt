package com.sopt.kakaobank.presentation.home

sealed class HomeItem {
    data class CheckLimitItem(val username: String) : HomeItem()
    data class BankBookItem1(val name: String, val leftover: String) : HomeItem()
    data class BankBookItem2(val name: String, val leftover: String) : HomeItem()
    data class BankBookItem3(val name: String, val leftover: String, val withdraw: String) : HomeItem()
}
