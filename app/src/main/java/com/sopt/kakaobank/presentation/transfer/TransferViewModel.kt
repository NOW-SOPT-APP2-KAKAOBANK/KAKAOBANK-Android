package com.sopt.kakaobank.presentation.transfer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.kakaobank.core.view.UiState
import com.sopt.kakaobank.data.ServicePool
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransferViewModel : ViewModel() {
    private val _getTransferRecent = MutableStateFlow<UiState<List<Transfer>>>(UiState.Loading)
    val getTransferRecent: StateFlow<UiState<List<Transfer>>> = _getTransferRecent

    private val _postTransferBookmark = MutableSharedFlow<UiState<Boolean>>()
    val postTransferBookmark: SharedFlow<UiState<Boolean>> get() = _postTransferBookmark

    init {
        getTransferRecent()
    }

    private fun getTransferRecent() = viewModelScope.launch {
        runCatching {
            ServicePool.transferApiService.getTransferRecent(1).map { it.toTransferEntity() }
        }.fold(
            { _getTransferRecent.value = UiState.Success(it) },
            { _getTransferRecent.value = UiState.Failure(it.message.toString()) }
        )
    }

    fun postTransferBookmark(markedAccountId: Int) = viewModelScope.launch {
        runCatching {
            ServicePool.transferApiService.postTransferBookmark(1, markedAccountId)
        }.fold({ }, { })
    }
}
