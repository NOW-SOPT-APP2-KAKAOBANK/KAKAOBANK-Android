package com.sopt.kakaobank.presentation.history

import android.content.Intent
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.context.initFormatAmount
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.core.view.UiState
import com.sopt.kakaobank.data.dto.response.ResponseAccountInfoDto
import com.sopt.kakaobank.data.dto.response.ResponseMonthPaymentDto
import com.sopt.kakaobank.databinding.FragmentHistoryBinding
import com.sopt.kakaobank.presentation.transfer.TransferActivity
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar

class HistoryFragment : BindingFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    private val historyViewModel by viewModels<HistoryViewModel>()
    private var month = getCurrentMonth()

    override fun initView() {
        statusBarColorOf(R.color.main) //status 색상 변경
        initBackBtnClickListener()
        initTransferBtnClickListener()
        initGetAccountObserve()
        initPreviousMonthBtnClickListener()
        initNextMonthBtnClickListener()
        updateMonthPayment(month)
    }

    // 뒤로 가기
    private fun initBackBtnClickListener() {
        binding.ibHistoryBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            statusBarColorOf(R.color.dark_gray1)
        }
    }

    // 이체하기
    private fun initTransferBtnClickListener() {
        binding.tvHistoryTransfer.setOnClickListener {
            startActivity(Intent(requireContext(), TransferActivity::class.java))
        }
    }

    // 계좌 정보
    private fun initGetAccountObserve() {
        historyViewModel.getAccountLiveData.observe(this) {
            when (it) {
                is UiState.Success -> initMyAccount(it.data)
                is UiState.Failure -> Timber.d("실패")
                is UiState.Loading -> Timber.d("로딩중")
            }
        }
    }

    // 계좌 정보 뷰 적용
    private fun initMyAccount(data: ResponseAccountInfoDto) {
        with(binding){
            val balance = initFormatAmount(data.balance)
            tvHistoryAccountName.text = data.accountName
            tvHistoryAccountNumber.text = createUnderlined(data.accountNumber)
            tvHistoryBalance.text = "${balance}원"
        }
    }

    // 이체 내역
    private fun initGetPaymentObserve() {
        historyViewModel.getPaymentLiveData.observe(this) {
            when (it) {
                is UiState.Success -> {
                    initHistoryAdapter(it.data.monthlyTransferList)
                    initMonthlyTransfer(it.data)
                }
                is UiState.Failure -> Timber.d("실패")
                is UiState.Loading -> Timber.d("로딩중")
            }
        }
    }

    // 결제 내역 뷰 적용
    private fun initMonthlyTransfer(data: ResponseMonthPaymentDto) {
        with(binding){
            val payment = initFormatAmount(data.payment)
            tvHistoryTotalSpent.text = "${payment}원"
            tvHistoryUsage.text = "${month}월 전체"
            tvHistoryDate.text =  "${getCurrentYear()} ${month}월"
        }
    }

    private fun initHistoryAdapter(data: List<ResponseMonthPaymentDto.MonthlyTransfer>) {
        binding.rvHistoryUsage.adapter = HistoryAdapter(
        ).apply {
            submitList(data)
        }
        binding.rvHistoryUsage.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun updateMonthPayment(month: Int) {
        historyViewModel.getMonthPayment(month)
        initGetPaymentObserve()
    }

    private fun getCurrentMonth(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.MONTH)
    }

    // 이전 달
    private fun initPreviousMonthBtnClickListener() {
        binding.ibHistoryLeft.setOnClickListener {
            month = getPreviousMonth()
            updateMonthPayment(month)
        }
    }
    private fun getPreviousMonth(): Int {
        month = if (month == 1) 12 else month - 1
        return month
    }

    // 다음 달
    private fun initNextMonthBtnClickListener() {
        binding.ibHistoryRight.setOnClickListener {
            month = getNextMonth()
            updateMonthPayment(month)
        }
    }
    private fun getNextMonth(): Int {
        month = if (month == 12) 1 else month + 1
        return month
    }

    // 현재 연도
    private fun getCurrentYear(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy")
        return dateFormat.format(calendar.time)
    }

    // 밑줄
    private fun createUnderlined(account: Long): SpannableString {
        return SpannableString(account.toString()).apply {
            setSpan(UnderlineSpan(), 0, length, 0)
        }
    }
}