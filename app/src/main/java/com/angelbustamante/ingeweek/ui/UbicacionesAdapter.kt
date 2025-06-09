package com.angelbustamante.ingeweek.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelbustamante.ingeweek.UbicacionItem
import com.angelbustamante.ingeweek.databinding.ItemUbicacionBinding

class UbicacionesAdapter : ListAdapter<UbicacionItem, UbicacionesAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUbicacionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemUbicacionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UbicacionItem) {
            binding.tvUbicName.text        = item.name
            binding.tvUbicAddress.text     = item.address
            binding.tvUbicDescription.text = item.description
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UbicacionItem>() {
            override fun areItemsTheSame(old: UbicacionItem, new: UbicacionItem) =
                old.name == new.name

            override fun areContentsTheSame(old: UbicacionItem, new: UbicacionItem) = old == new
        }
    }
}