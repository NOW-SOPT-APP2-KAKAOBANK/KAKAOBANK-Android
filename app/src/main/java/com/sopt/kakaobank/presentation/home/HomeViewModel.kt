package com.sopt.kakaobank.presentation.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val homeItems: List<HomeItem> = listOf(
        HomeItem.CheckLimitItem("김미정님의 신용점수는"),
        HomeItem.BankBookItem1("햄들의 통장"),
        HomeItem.BankBookItem2("햄통장"),
        HomeItem.BankBookItem3("김미정의 통장")
    )
}