package com.sopt.kakaobank.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.kakaobank.data.ServicePool.homeApiService
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class HomeViewModel : ViewModel() {

    private val _homeItems = MutableLiveData<List<HomeItem>>()
    val homeItems: LiveData<List<HomeItem>> get() = _homeItems

    fun getHomeItems() {
        viewModelScope.launch {
            try {
                val response = homeApiService.getAccountList(1)
                val homeItems = mutableListOf<HomeItem>()
                homeItems.add(HomeItem.CheckLimitItem("김미정"))

                val numberFormat = NumberFormat.getNumberInstance(Locale.KOREA)

                response.forEachIndexed { index, dto ->
                    val balanceWithWon = "${numberFormat.format(dto.balance)}원"
                    when (index % 3) {
                        0 -> homeItems.add(HomeItem.BankBookItem1(dto.accountName, balanceWithWon))
                        1 -> homeItems.add(HomeItem.BankBookItem2(dto.accountName, balanceWithWon))
                        2 -> homeItems.add(HomeItem.BankBookItem3(dto.accountName, balanceWithWon, "3,000,041원"))
                    }
                }
                _homeItems.value = homeItems
            } catch (e: Exception) {
                // 에러 처리
            }
        }
    }
}