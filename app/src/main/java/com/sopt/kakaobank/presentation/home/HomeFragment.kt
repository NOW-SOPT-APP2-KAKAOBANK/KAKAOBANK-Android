package com.sopt.kakaobank.presentation.home

import android.graphics.Rect
import android.os.Bundle
import android.telephony.PhoneNumberUtils.formatNumber
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingFragment
import com.sopt.kakaobank.databinding.FragmentHomeBinding
import com.sopt.kakaobank.databinding.ItemBankBook1Binding
import com.sopt.kakaobank.presentation.history.HistoryFragment
import java.text.NumberFormat
import java.util.Locale

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val formattedHomeItems = viewModel.homeItems.map { item ->
            when (item) {
                is HomeItem.BankBookItem3 -> {
                    val formattedWithdraw = formatNumber(item.withdraw)
                    item.copy(withdraw = formattedWithdraw)
                }
                else -> item
            }
        }.toMutableList()

        val adapter = HomeItemAdapter(formattedHomeItems, this)
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.homeRecyclerView.adapter = adapter

        // recyclerview item 간 간격 조정
        val spaceInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 9f, resources.displayMetrics
        ).toInt()

        binding.homeRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                outRect.bottom = spaceInPixels
            }
        })
    }

    fun navigateToHistory() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.cl_home_fragment, HistoryFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun formatNumber(numberStr: String) : String {
        val number = numberStr.toIntOrNull() ?: return numberStr
        return NumberFormat.getNumberInstance(Locale.US).format(number)
    }

    override fun initView() {
        // 로직 작성
    }

}