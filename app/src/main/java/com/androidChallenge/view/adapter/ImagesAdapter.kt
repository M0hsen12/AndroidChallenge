package com.androidChallenge.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.androidChallenge.R
import com.androidChallenge.databinding.ItemImageBinding
import com.androidChallenge.models.images.HitsItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class ImagesAdapter(val onItemClick:(HitsItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HitsItem>() {

        override fun areItemsTheSame(oldItem: HitsItem, newItem: HitsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HitsItem, newItem: HitsItem): Boolean {
            return oldItem.id == newItem.id && oldItem.user == oldItem.user
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return  ImagesHolderClass(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false), onItemClick  )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImagesHolderClass -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<HitsItem>) {
        differ.submitList(list)
    }

    class ImagesHolderClass
    constructor(
        val binding: ItemImageBinding,
       val  onItemClick:(HitsItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HitsItem) = with(binding) {
            itemImageParent.setOnClickListener {
                onItemClick.invoke(item)
            }


            itemImageUploader.text = item.user
            Glide.with(itemImage.context)
                .load(item.previewURL)
                .apply(RequestOptions().transform(RoundedCorners(22)))
                .into(itemImage)
        }
    }

}

