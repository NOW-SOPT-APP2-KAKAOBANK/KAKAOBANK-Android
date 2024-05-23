package com.sopt.kakaobank.data.api

import com.sopt.kakaobank.core.util.KeyStorage.ACCOUNT_LIST
import com.sopt.kakaobank.core.util.KeyStorage.API
import com.sopt.kakaobank.core.util.KeyStorage.V1
import com.sopt.kakaobank.data.dto.response.ResponseAccountDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApiService {

    @GET("$API/$V1/$ACCOUNT_LIST/{memberId}")
    suspend fun getAccountList(
        @Path("memberId") memberId: Int
    ): List<ResponseAccountDto>

}