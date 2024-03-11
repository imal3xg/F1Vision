package com.example.f1vision.ui.driver.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.f1vision.data.repository.Driver
import com.example.f1vision.databinding.DriverItemBinding

class DriverListAdapter(private val context: Context, private val onItemClick: (Driver) -> Unit): ListAdapter<Driver, DriverListAdapter.DriverListViewHolder>(
    DriverDiffCallBack
) {
    inner class DriverListViewHolder(private val binding: DriverItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindDriver(d: Driver) {
            binding.pilotoImageView.load(d.headshotUrl)
            binding.pilotoNameText.text = d.fullName
            binding.pilotoNumber.text = d.driverNumber.toString()
        }
    }

    private object DriverDiffCallBack : DiffUtil.ItemCallback<Driver>() {
        override fun areItemsTheSame(oldItem: Driver, newItem: Driver) = oldItem.driverNumber == newItem.driverNumber
        override fun areContentsTheSame(oldItem: Driver, newItem: Driver) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverListViewHolder {
        val binding = DriverItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DriverListViewHolder, position: Int) {
        val Driver = getItem(position)
        holder.bindDriver(Driver)
        holder.itemView.setOnClickListener {
            onItemClick(Driver)
        }
    }
}