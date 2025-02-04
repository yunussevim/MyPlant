package com.hubx.myplant.pages.onboarding.pager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.hubx.myplant.R
import com.hubx.myplant.databinding.FragmentOnboardingPagerBinding

class OnboardingPagerFragment : Fragment() {
    private var _binding: FragmentOnboardingPagerBinding? = null
    private val binding get() = _binding!!

    private val pageList = listOf(
        OnboardingPage(R.string.onboarding_header_second, R.string.onboarding_header_second_bold, R.drawable.onboarding_page_2_bg),
        OnboardingPage(R.string.onboarding_header_third, R.string.onboarding_header_third_bold, R.drawable.onboarding_page_3_bg),
        OnboardingPage(R.string.onboarding_header_third, R.string.onboarding_header_third_bold, R.drawable.onboarding_page_3_bg)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(pageList) { currentPosition ->
            if (currentPosition < pageList.size - 2) {
                binding.viewPager.currentItem = currentPosition + 1
            } else {
                completeOnboardingAndNavigate()
            }
        }
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == pageList.size - 1) {
                    completeOnboardingAndNavigate()
                }
            }
        })
    }

    private fun completeOnboardingAndNavigate() {

        val prefs = requireContext().getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("onboarding_completed", true).apply()

        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.onboardingStartFragment, true)
            .build()
        findNavController().navigate(R.id.action_pager_to_paywall, null, navOptions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}