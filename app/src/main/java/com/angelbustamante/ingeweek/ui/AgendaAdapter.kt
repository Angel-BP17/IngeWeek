package com.angelbustamante.ingeweek.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelbustamante.ingeweek.AgendaItem
import com.angelbustamante.ingeweek.databinding.ItemAgendaBinding

class AgendaAdapter : ListAdapter<AgendaItem, AgendaAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAgendaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAgendaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AgendaItem) {
            binding.tvTime.text = item.time
            binding.tvTitle.text = item.title
            binding.tvLocation.text = item.location
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<AgendaItem>() {
            override fun areItemsTheSame(old: AgendaItem, new: AgendaItem) =
                old.time == new.time && old.title == new.title

            override fun areContentsTheSame(old: AgendaItem, new: AgendaItem) = old == new
        }
    }
}