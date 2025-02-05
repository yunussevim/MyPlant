package com.hubx.myplant.pages.onboarding.paywall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hubx.myplant.databinding.FeaturesListItemBinding

class FeatureListAdapter(private val items: List<FeatureListItem>) :
    RecyclerView.Adapter<FeatureListAdapter.HorizontalViewHolder>() {

    inner class HorizontalViewHolder(val binding: FeaturesListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val binding = FeaturesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            icFeature.setImageResource(item.iconRes)
            featureHeader.text = holder.binding.root.context.getString(item.header)
            featureDesc.text = holder.binding.root.context.getString(item.description)
        }
    }

    override fun getItemCount(): Int = items.size
}
