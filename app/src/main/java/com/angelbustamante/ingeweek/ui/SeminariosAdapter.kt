package com.angelbustamante.ingeweek.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelbustamante.ingeweek.SeminarioItem
import com.angelbustamante.ingeweek.databinding.ItemSeminarioBinding

class SeminariosAdapter :
    ListAdapter<SeminarioItem, SeminariosAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSeminarioBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSeminarioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SeminarioItem) {
            binding.tvTopic.text    = item.topic
            binding.tvSpeaker.text  = item.speaker
            binding.tvSchedule.text = item.schedule
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<SeminarioItem>() {
            override fun areItemsTheSame(old: SeminarioItem, new: SeminarioItem) =
                old.topic == new.topic && old.schedule == new.schedule

            override fun areContentsTheSame(old: SeminarioItem, new: SeminarioItem) =
                old == new
        }
    }
}