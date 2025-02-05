package com.hubx.myplant.pages.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.CustomTarget
import com.hubx.myplant.databinding.QuestionsListItemBinding

class QuestionsListAdapter(private val items: List<QuestionsListItem>) :
    RecyclerView.Adapter<QuestionsListAdapter.HorizontalViewHolder>() {

    inner class HorizontalViewHolder(val binding: QuestionsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val binding = QuestionsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            Glide.with(itemCard.context)
                .load(item.src)
                .transform(RoundedCorners(36))
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: com.bumptech.glide.request.transition.Transition<in Drawable>?
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