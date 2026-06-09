package com.training.ptojectone.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.ptojectone.data.model.AchievementsResponseModel
import com.training.ptojectone.databinding.RowAchievementsBinding

class AchievementAdapter(private val list: List<AchievementsResponseModel>) :
    RecyclerView.Adapter<AchievementAdapter.MedalViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MedalViewHolder {
        val binding =
            RowAchievementsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MedalViewHolder(private val binding: RowAchievementsBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(model: AchievementsResponseModel) {
                binding.model = model
                binding.recyclerViewMedal.adapter = RecordsAdapter(model.records)
            }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}