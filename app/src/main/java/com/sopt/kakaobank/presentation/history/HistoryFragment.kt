package com.sopt.kakaobank.presentation.history

import androidx.navigation.fragment.findNavController
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.core.util.fragment.statusBarColorOf
import com.sopt.kakaobank.databinding.FragmentHistoryBinding

class HistoryFragment : BindingFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    override fun initView() {
        statusBarColorOf(R.color.main) //status 색상 변경
        setBackButton()
    }

    // 뒤로 가기
    private fun setBackButton() {
        binding.btnHistoryBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}