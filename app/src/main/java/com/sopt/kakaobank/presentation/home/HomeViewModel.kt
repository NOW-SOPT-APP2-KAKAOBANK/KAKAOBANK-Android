package com.sopt.kakaobank.presentation.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val homeItems: List<HomeItem> = listOf(
        HomeItem.CheckLimitItem("김윤서"),
        HomeItem.BankBookItem1("융들의 통장", "0"),
        HomeItem.BankBookItem2("융통장", "0"),
        HomeItem.BankBookItem3("김윤서의 통장", "41","3000041")
    )
}