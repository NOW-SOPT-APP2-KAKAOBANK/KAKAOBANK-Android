package com.sopt.kakaobank.presentation

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.sopt.kakaobank.R
import com.sopt.kakaobank.core.base.BindingActivity
import com.sopt.kakaobank.core.view.UiState
import com.sopt.kakaobank.databinding.ActivityMainBinding
import com.sopt.kakaobank.presentation.home.HomeFragment
import timber.log.Timber

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val exampleViewModel by viewModels<ExampleViewModel>()

    override fun initView() {
        // 로직 작성
        // exampleObserve()
        initHomeFragment()
        initBottomNavClickListener()
        initBottomNavBadge()
    }

    private fun initHomeFragment(){
        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvHome.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvHome.id, HomeFragment())
                .commit()
        }
    }

    private fun initBottomNavClickListener() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_my_bank -> {
                    replaceFragment(HomeFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }

    private fun initBottomNavBadge() {
        binding.bnvHome.getOrCreateBadge(R.id.menu_notification).isVisible = true
        binding.bnvHome.getOrCreateBadge(R.id.menu_my_page).isVisible = true
    }

    private fun exampleObserve() {
        exampleViewModel.exampleLiveData.observe(this) {
            when (it) {
                is UiState.Success -> Timber.d("성공")
                is UiState.Failure -> Timber.d("실패")
                is UiState.Loading -> Timber.d("로딩중")
            }
        }
    }
}