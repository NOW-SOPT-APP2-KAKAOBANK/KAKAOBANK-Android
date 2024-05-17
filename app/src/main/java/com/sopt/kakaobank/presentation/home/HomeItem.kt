package com.sopt.kakaobank.presentation.home

sealed class HomeItem {
    data class CheckLimitItem(val name: String) : HomeItem()
    data class BankBookItem1(val name: String) : HomeItem()
    data class BankBookItem2(val name: String) : HomeItem()
    data class BankBookItem3(val name: String) : HomeItem()
}
