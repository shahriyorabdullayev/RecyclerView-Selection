package me.shakhriyor.selectedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shakhriyor.selectedrecyclerview.databinding.ItemSingleSelectionBinding

class MultiSelectionAdapter : ListAdapter<Item, MultiSelectionAdapter.MultiViewHolder>(diffCallback) {

    inner class MultiViewHolder(private val binding: ItemSingleSelectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                tvName.text = item.name
                if (item.isChecked) {
                    llBg.setBackgroundResource(R.drawable.bg_selected)
                    tvName.setTextColor(binding.tvName.resources.getColor(R.color.white))
                } else {
                    llBg.setBackgroundResource(R.drawable.bg_not_selected)
                    tvName.setTextColor(binding.tvName.resources.getColor(R.color.black))
                }

                root.setOnClickListener {
                    item.isChecked = !item.isChecked
                    if (item.isChecked) {
                        llBg.setBackgroundResource(R.drawable.bg_selected)
                        tvName.setTextColor(binding.tvName.resources.getColor(R.color.white))
                    } else {
                        llBg.setBackgroundResource(R.drawable.bg_not_selected)
                        tvName.setTextColor(binding.tvName.resources.getColor(R.color.black))
                    }
                }
            }

        }

    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHolder {
        return MultiViewHolder(ItemSingleSelectionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MultiViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}