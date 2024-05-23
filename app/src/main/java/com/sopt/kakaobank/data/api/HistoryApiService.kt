package com.sopt.kakaobank.data.api

import com.sopt.kakaobank.core.util.KeyStorage.ACCOUNT_ID
import com.sopt.kakaobank.core.util.KeyStorage.ACCOUNT_INFO
import com.sopt.kakaobank.core.util.KeyStorage.MONTH
import com.sopt.kakaobank.core.util.KeyStorage.PAYMENT
import com.sopt.kakaobank.data.api.ExampleApiService.Companion.API
import com.sopt.kakaobank.data.api.ExampleApiService.Companion.V1
import com.sopt.kakaobank.data.dto.response.ResponseAccountInfoDto
import com.sopt.kakaobank.data.dto.response.ResponseMonthPaymentDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HistoryApiService {
    // 내 계좌 정보 조회
    @GET("$API/$V1/$ACCOUNT_INFO/{$ACCOUNT_ID}")
    suspend fun getAccountInfo(
        @Path(value = ACCOUNT_ID) accountId: Int
    ): ResponseAccountInfoDto

    // 월별 거래 내역
    @GET("$API/$V1/$PAYMENT/{$ACCOUNT_ID}")
    suspend fun getMonthPayment(
        @Path(value = ACCOUNT_ID) accountId: Int,
        @Query(value = MONTH) month: Int
    ): ResponseMonthPaymentDto
}