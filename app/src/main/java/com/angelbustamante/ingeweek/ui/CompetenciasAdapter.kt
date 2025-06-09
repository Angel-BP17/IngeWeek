package com.angelbustamante.ingeweek.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelbustamante.ingeweek.CompetenciaItem
import com.angelbustamante.ingeweek.databinding.ItemCompetenciaBinding

class CompetenciasAdapter : ListAdapter<CompetenciaItem, CompetenciasAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCompetenciaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCompetenciaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CompetenciaItem) {
            binding.tvCompName.text = item.name
            binding.tvCompDesc.text = item.description
            binding.tvCompTime.text = item.time
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CompetenciaItem>() {
            override fun areItemsTheSame(old: CompetenciaItem, new: CompetenciaItem) =
                old.name == new.name && old.time == new.time

            override fun areContentsTheSame(old: CompetenciaItem, new: CompetenciaItem) = old == new
        }
    }
}