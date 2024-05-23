package com.sopt.kakaobank.presentation.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.kakaobank.core.view.UiState
import com.sopt.kakaobank.data.ServicePool
import com.sopt.kakaobank.data.dto.response.ResponseAccountInfoDto
import com.sopt.kakaobank.data.dto.response.ResponseMonthPaymentDto
import kotlinx.coroutines.launch

class HistoryViewModel : ViewModel() {
    private val _getAccountLiveData: MutableLiveData<UiState<ResponseAccountInfoDto>> = MutableLiveData()
    val getAccountLiveData: MutableLiveData<UiState<ResponseAccountInfoDto>> = _getAccountLiveData

    private val _getPaymentLiveData: MutableLiveData<UiState<ResponseMonthPaymentDto>> = MutableLiveData()
    val getPaymentLiveData: MutableLiveData<UiState<ResponseMonthPaymentDto>> = _getPaymentLiveData

    init {
        getAccountInfo()
    }

    // 내 계좌 정보 조회
    private fun getAccountInfo() = viewModelScope.launch {
        _getAccountLiveData.value = UiState.Loading
        runCatching {
            ServicePool.historyService.getAccountInfo(accountId = 1)
        }.fold(
            { _getAccountLiveData.value = UiState.Success(it) },
            { _getAccountLiveData.value = UiState.Failure(it.message.toString())}
        )
    }

    // 월별 거래 내역
    fun getMonthPayment(month: Int) = viewModelScope.launch {
        _getPaymentLiveData.value = UiState.Loading
        runCatching {
            ServicePool.historyService.getMonthPayment(accountId = 1, month = month)
        }.fold(
            { _getPaymentLiveData.value = UiState.Success(it) },
            { _getPaymentLiveData.value = UiState.Failure(it.message.toString()) }
        )
    }
}