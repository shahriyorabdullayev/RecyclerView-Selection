package me.shakhriyor.selectedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shakhriyor.selectedrecyclerview.databinding.ItemSingleSelectionBinding

class SingleSelectionAdapter : ListAdapter<Item, SingleSelectionAdapter.SingleViewHolder>(
    diffCallback) {

    private var checkedPosition = 0

    inner class SingleViewHolder(private val binding: ItemSingleSelectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            if (checkedPosition == -1) {
                binding.llBg.setBackgroundResource(R.drawable.bg_not_selected)
                binding.tvName.setTextColor(binding.tvName.resources.getColor(R.color.black))
            } else {
                if (checkedPosition == adapterPosition) {
                    binding.llBg.setBackgroundResource(R.drawable.bg_selected)
                    binding.tvName.setTextColor(binding.tvName.resources.getColor(R.color.white))
                } else {
                    binding.llBg.setBackgroundResource(R.drawable.bg_not_selected)
                    binding.tvName.setTextColor(binding.tvName.resources.getColor(R.color.black))
                }
            }
            binding.root.setOnClickListener {
                binding.llBg.setBackgroundResource(R.drawable.bg_selected)
                binding.tvName.setTextColor(binding.tvName.resources.getColor(R.color.white))
                if (checkedPosition != adapterPosition) {
                    notifyItemChanged(checkedPosition)
                    checkedPosition = adapterPosition
                }
            }
            binding.tvName.text = item.name
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleViewHolder {
        return SingleViewHolder(ItemSingleSelectionBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: SingleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}