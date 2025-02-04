package com.hubx.myplant.pages.onboarding.pager

import android.graphics.Typeface
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.hubx.myplant.databinding.ItemViewpagerBinding
import kotlin.math.log

class ViewPagerAdapter(
    private val pages: List<OnboardingPage>,
    private val onButtonClick: (currentPosition: Int) -> Unit
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pageData: OnboardingPage, position: Int) {
            binding.vpImageBg.setImageResource(pageData.imageResId)
            binding.vpNextButton.setOnClickListener {
                onButtonClick(position)
            }
            val text = binding.root.context.getString(pageData.textResId)
            val boldPart = binding.root.context.getString(pageData.textBoldResId)

            binding.vpBrush1.visibility = View.GONE
            binding.vpBrush2.visibility = View.VISIBLE
            if(position == 0){
                binding.vpBrush1.visibility = View.VISIBLE
                binding.vpBrush2.visibility = View.GONE
            }
            binding.vpHeader.text = makeBold(text, boldPart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewpagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pages[position], position)
    }

    override fun getItemCount(): Int = pages.size

    private fun makeBold(text: String, boldPart: String): SpannableString{
        val spannableString = SpannableString(text)

        val start = text.indexOf(boldPart)
        val end = start + boldPart.length

        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }
}
