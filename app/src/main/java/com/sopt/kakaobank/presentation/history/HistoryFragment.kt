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
import com.sopt.kakaobank.data.dto.response.ResponseMonthPaymentDto
import com.sopt.kakaobank.databinding.FragmentHistoryBinding
import com.sopt.kakaobank.presentation.transfer.TransferActivity
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar

class HistoryFragment : BindingFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    private val historyViewModel by viewModels<HistoryViewModel>()
    var month = getCurrentMonth()

    override fun initView() {
        statusBarColorOf(R.color.main) //status 색상 변경
        initBackBtnClickListener()
        initTransferBtnClickListener()
        initGetAccountObserve()
        initMonthBtnClickListener()
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
                is UiState.Success -> {
                    with(binding){
                        val spannableString = SpannableString(it.data.accountNumber.toString()).apply {
                            setSpan(UnderlineSpan(), 0, length, 0)
                        }
                        val balance = initFormatAmount(it.data.balance)
                        tvHistoryAccountName.text = it.data.accountName
                        tvHistoryAccountNumber.text = spannableString
                        tvHistoryBalance.text = "${balance}원"
                    }
                }
                is UiState.Failure -> Timber.d("실패")
                is UiState.Loading -> Timber.d("로딩중")
            }
        }
    }

    // 이체 내역
    private fun initMonthBtnClickListener() {
        binding.ibHistoryLeft.setOnClickListener {
            month = getPreviousMonth()
            updateMonthPayment(month)
        }

        binding.ibHistoryRight.setOnClickListener {
            month = getNextMonth()
            updateMonthPayment(month)
        }
    }

    // 달 선택
    private fun initGetPaymentObserve(month: String) {

        historyViewModel.getPaymentLiveData.observe(this) {
            when (it) {
                is UiState.Success -> {
                    initHistoryAdapter(it.data.monthlyTransferList)
                    with(binding){
                        val payment = initFormatAmount(it.data.payment)
                        tvHistoryTotalSpent.text = "${payment}원"
                        tvHistoryUsage.text = "${month}월 전체"
                        tvHistoryDate.text =  "${getCurrentYear()} ${month}월"
                    }
                }
                is UiState.Failure -> Timber.d("실패")
                is UiState.Loading -> Timber.d("로딩중")
            }
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
        initGetPaymentObserve(month.toString())
    }

    private fun getCurrentMonth(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.MONTH)
    }

    // 이전 달
    private fun getPreviousMonth(): Int {
        month -= 1
        if (month < 1) {
            month = 12
        }
        return month
    }

    // 다음 달
    private fun getNextMonth(): Int {
        month += 1
        if (month > 12) {
            month = 1
        }
        return month
    }

    // 현재 연도
    fun getCurrentYear(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy")
        return dateFormat.format(calendar.time)
    }
}