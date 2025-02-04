package com.hubx.myplant.pages.onboarding.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hubx.myplant.R
import com.hubx.myplant.databinding.FragmentOnboardingBinding

class OnboardingStartFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding_to_pager)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}