package com.sopt.kakaobank.presentation.transfer

import androidx.annotation.DrawableRes

data class Transfer(
    @DrawableRes val profile: Int,
    val name: String,
    val account: String,
    var bookmark: Boolean,
)