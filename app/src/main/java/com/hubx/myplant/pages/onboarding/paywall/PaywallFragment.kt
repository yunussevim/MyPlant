package com.hubx.myplant.pages.onboarding.paywall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubx.myplant.R
import com.hubx.myplant.databinding.FragmentOnboardingPagerBinding
import com.hubx.myplant.databinding.FragmentPaywallBinding
import com.hubx.myplant.util.TextUtil

class PaywallFragment : Fragment() {

    val features = listOf(
        FeatureListItem(R.drawable.feature_scanner, R.string.unlimited, R.string.plant_identify),
        FeatureListItem(R.drawable.feature_speedometer, R.string.faster, R.string.process),
        FeatureListItem(R.drawable.feature_speedometer, R.string.faster, R.string.process),
    )

    private var _binding: FragmentPaywallBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaywallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnX.setOnClickListener {
            findNavController().navigate(R.id.action_paywall_to_main)
        }

        val header = binding.root.context.getString(R.string.paywall_header)
        val boldPart = binding.root.context.getString(R.string.paywall_header_bold)
        binding.txtPaywallHeader.text = TextUtil.makeBold(header, boldPart)

        binding.rvFeature.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = FeatureListAdapter(features)
        binding.rvFeature.adapter = adapter

        binding.button1.discountBanner.visibility = View.GONE
        binding.button1.radioHeader.text = requireContext().getString(R.string.payment_opt1_header)
        binding.button2.radioHeader.text = requireContext().getString(R.string.payment_opt2_header)
        binding.button1.radioDesc.text = requireContext().getString(R.string.payment_opt1_desc)
        binding.button2.radioDesc.text = requireContext().getString(R.string.payment_opt2_desc)

        binding.button1.customButtonRoot.setOnClickListener {
            binding.button1.btnContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_payment_bg)
            binding.button1.imgRadio.setImageResource(R.drawable.radio_selected)
            binding.button2.discountContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.discount_banner_unselected_bg)
            binding.button2.btnContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.selectable_payment_bg)
            binding.button2.imgRadio.setImageResource(R.drawable.radio_unselected)
        }
        binding.button2.customButtonRoot.setOnClickListener {
            binding.button2.btnContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_payment_bg)
            binding.button2.imgRadio.setImageResource(R.drawable.radio_selected)
            binding.button2.discountContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.discount_banner_selected_bg)
            binding.button1.btnContainer.background = ContextCompat.getDrawable(requireContext(), R.drawable.selectable_payment_bg)
            binding.button1.imgRadio.setImageResource(R.drawable.radio_unselected)
        }

    }

}