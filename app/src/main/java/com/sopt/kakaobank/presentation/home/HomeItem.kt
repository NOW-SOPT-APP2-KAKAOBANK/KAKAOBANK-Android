package com.sopt.kakaobank.presentation.home

sealed class HomeItem {
    data class CheckLimitItem(val text: String) : HomeItem()
    data class BankBookItem1(val text: String) : HomeItem()
    data class BankBookItem2(val text: String) : HomeItem()
    data class BankBookItem3(val text: String) : HomeItem()
}
