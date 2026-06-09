package com.training.ptojectone.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.ptojectone.data.model.RecordsModel
import com.training.ptojectone.databinding.RowMedalBinding

class RecordsAdapter(private val list: List<RecordsModel>) : RecyclerView.Adapter<RecordsAdapter.MedalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val binding =
            RowMedalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class MedalViewHolder(private val binding: RowMedalBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(model: RecordsModel) {
            binding.model = model
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}