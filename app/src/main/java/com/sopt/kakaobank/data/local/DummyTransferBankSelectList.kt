package com.sopt.kakaobank.data.local

import com.sopt.kakaobank.R
import com.sopt.kakaobank.presentation.transfer.bottomsheet.TransferBankSelectContentEntity
import com.sopt.kakaobank.presentation.transfer.bottomsheet.TransferBankSelectTitleEntity

object DummyTransferBankSelectList {
    val data: List<TransferBankSelectTitleEntity> = listOf(
        TransferBankSelectTitleEntity(
            title = "은행",
            content = listOf(
                TransferBankSelectContentEntity(R.drawable.ic_kakao_bank, "카카오뱅크"),
                TransferBankSelectContentEntity(R.drawable.ic_kukmin_bank, "국민은행"),
                TransferBankSelectContentEntity(R.drawable.ic_ibk_bank, "기업은행"),
                TransferBankSelectContentEntity(R.drawable.ic_nong_bank, "농협은행"),
                TransferBankSelectContentEntity(R.drawable.ic_sanup_bank, "산업은행"),
                TransferBankSelectContentEntity(R.drawable.ic_sinhan_bank, "신한은행"),
                TransferBankSelectContentEntity(R.drawable.ic_uri_bank, "우리은행"),
                TransferBankSelectContentEntity(R.drawable.ic_hankukcity_bank, "한국씨티은행"),
                TransferBankSelectContentEntity(R.drawable.ic_hana_bank, "하나은행"),
                TransferBankSelectContentEntity(R.drawable.ic_sc_bank, "SC제일은행"),
                TransferBankSelectContentEntity(R.drawable.ic_kyungnam_bank, "경남은행"),
                TransferBankSelectContentEntity(R.drawable.ic_kangju_bank, "광주은행"),
                TransferBankSelectContentEntity(R.drawable.ic_daegu_bank, "대구은행"),
                TransferBankSelectContentEntity(R.drawable.ic_doichi_bank, "도이치은행"),
                TransferBankSelectContentEntity(R.drawable.ic_bankof_bank, "뱅크오브아메리카"),
                TransferBankSelectContentEntity(R.drawable.ic_bnk_bank, "부산은행"),
                TransferBankSelectContentEntity(R.drawable.ic_sanlim_bank, "산림조합중앙회"),
                TransferBankSelectContentEntity(R.drawable.ic_sb_bank, "저축은행"),
                TransferBankSelectContentEntity(R.drawable.ic_saemaeul_bank, "새마을금고"),
                TransferBankSelectContentEntity(R.drawable.ic_suhup_bank, "수협은행"),
                TransferBankSelectContentEntity(R.drawable.ic_sinhup_bank, "신협중앙회"),
                TransferBankSelectContentEntity(R.drawable.ic_ucheguk_bank, "우체국"),
                TransferBankSelectContentEntity(R.drawable.ic_zeonbuk_bank, "전북은행"),
                TransferBankSelectContentEntity(R.drawable.ic_jeju_bank, "제주은행"),
                TransferBankSelectContentEntity(R.drawable.ic_chinageonseol_bank, "중국건설은행"),
                TransferBankSelectContentEntity(R.drawable.ic_chinagongsang_bank, "중국공상은행"),
                TransferBankSelectContentEntity(R.drawable.ic_china_bank, "중국은행"),
                TransferBankSelectContentEntity(R.drawable.ic_bnp_bank, "BNP파리바은행"),
                TransferBankSelectContentEntity(R.drawable.ic_hsbc_bank, "HSBC은행"),
                TransferBankSelectContentEntity(R.drawable.ic_jpmogan_bank, "JP모간체이스은행"),
                TransferBankSelectContentEntity(R.drawable.ic_kbank_bank, "케이뱅크"),
                TransferBankSelectContentEntity(R.drawable.ic_toss_bank, "토스뱅크"),
            )
        ),
        TransferBankSelectTitleEntity(
            title = "증권",
            content = listOf(
                TransferBankSelectContentEntity(R.drawable.ic_nong_bank, "증권 이름1"),
                TransferBankSelectContentEntity(R.drawable.ic_bnk_bank, "증권 이름2")
            )
        )
    )
}