package com.hubx.myplant.pages.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.hubx.myplant.databinding.PlantsListItemBinding

class PlantsListAdapter(private val items: List<PlantsListItem>) :
    RecyclerView.Adapter<PlantsListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PlantsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlantsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            Glide.with(itemCard.context)
                .load(item.src)
                .transform(RoundedCorners(36))
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        itemCard.background = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })

            itemText.text = item.text
        }
    }

    override fun getItemCount(): Int = items.size
}
