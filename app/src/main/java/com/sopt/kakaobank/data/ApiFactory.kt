package com.sopt.kakaobank.data

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.kakaobank.BuildConfig.BASE_URL
import com.sopt.kakaobank.data.api.ExampleApiService
import com.sopt.kakaobank.data.api.TransferApiService
import com.sopt.kakaobank.data.api.HomeApiService
import com.sopt.kakaobank.data.api.HistoryApiService
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {

    private fun getLogOkHttpClient(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d("Retrofit2", "CONNECTION INFO -> $message")
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(getLogOkHttpClient())
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val exampleService = ApiFactory.create<ExampleApiService>()
    val homeApiService = ApiFactory.create<HomeApiService>()
    val historyService = ApiFactory.create<HistoryApiService>()
    val transferApiService = ApiFactory.create<TransferApiService>()
}