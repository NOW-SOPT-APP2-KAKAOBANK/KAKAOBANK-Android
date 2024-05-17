package com.sopt.kakaobank.presentation.history

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.data.dto.response.History
import com.sopt.kakaobank.databinding.FragmentHistoryBinding
import java.text.DecimalFormat

class HistoryFragment : BindingFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    override fun initView() {
        statusBarColorOf(R.color.main) //status 색상 변경
        setBackButton()
        setHistoryList()
    }

    // 뒤로 가기
    private fun setBackButton() {
        binding.btnHistoryBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    // 1000원 단위 콤마
    private fun formatAmount(amount : Int): String {
        val dec = DecimalFormat("#,###")
        return dec.format(amount)
    }

    private fun setHistoryList() {
        val amount = 10000 //더미 데이터
        val formattedAmount = formatAmount(amount)
        val historyAdapter = HistoryAdapter()

        binding.rvHistoryUsage.run {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        historyAdapter.setHistoryList(mockHistoryList(formattedAmount))
    }

    // 더미 데이터
    private fun mockHistoryList(amount: String) = listOf(
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        ),
        History(
            historyDate = "03.21",
            historyName = "김미정",
            historySpent = amount,
            historyBalance = "0원"
        )
    )
}