package com.sopt.kakaobank.data.api

import com.sopt.kakaobank.core.util.KeyStorage.ACCOUNT_ID
import com.sopt.kakaobank.core.util.KeyStorage.API
import com.sopt.kakaobank.core.util.KeyStorage.BOOKMAKR
import com.sopt.kakaobank.core.util.KeyStorage.MARKED_ACCOUNT_ID
import com.sopt.kakaobank.core.util.KeyStorage.MY_ACCOUNT_ID
import com.sopt.kakaobank.core.util.KeyStorage.RECENT_TRANSFERS
import com.sopt.kakaobank.core.util.KeyStorage.V1
import com.sopt.kakaobank.data.dto.response.ResponseTransferRecentDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransferApiService {
    @GET("$API/$V1/$RECENT_TRANSFERS/{$ACCOUNT_ID}")
    suspend fun getTransferRecent(
        @Path(value = ACCOUNT_ID) accountId: Int,
    ): List<ResponseTransferRecentDto>

    @POST("$API/$V1/$RECENT_TRANSFERS/{$MY_ACCOUNT_ID}/$BOOKMAKR/{$MARKED_ACCOUNT_ID}")
    suspend fun postTransferBookmark(
        @Path(value = MY_ACCOUNT_ID) myAccountId: Int,
        @Path(value = MARKED_ACCOUNT_ID) markedAccountId: Int,
    )

    @DELETE("$API/$V1/$RECENT_TRANSFERS/{$MY_ACCOUNT_ID}/$BOOKMAKR/{$MARKED_ACCOUNT_ID}")
    suspend fun deleteTransferBookmark(
        @Path(value = MY_ACCOUNT_ID) myAccountId: Int,
        @Path(value = MARKED_ACCOUNT_ID) markedAccountId: Int,
    )
}