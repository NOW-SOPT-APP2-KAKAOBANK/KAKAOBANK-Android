package com.sopt.kakaobank.data.api

import com.sopt.kakaobank.data.dto.response.ResponseAccountDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiService {
    companion object {
        const val API = "api"
        const val V1 = "v1"
        const val ACCOUNT_LIST = "account-list"
    }

    @GET("$API/$V1/$ACCOUNT_LIST/{memberId}")
    fun getAccountList(
        @Path("memberId") memberId: Int
    ): Call<List<ResponseAccountDto>>
}