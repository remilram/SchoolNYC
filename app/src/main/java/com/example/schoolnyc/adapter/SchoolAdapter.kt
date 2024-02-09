package com.example.schoolnyc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolnyc.R
import com.example.schoolnyc.databinding.SchoolItemBinding
import com.example.schoolnyc.model.School

class SchoolAdapter(val schools : List<School>, val clickListener : (School) -> Unit) : RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>() {

    class SchoolViewHolder(private val binding : SchoolItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(school : School, clickListener : (School) -> Unit) {
            binding.school = school;

            binding.schoolItem.setOnClickListener {
                clickListener(school)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val binding : SchoolItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.school_item,
            parent, false)

        return SchoolViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return schools.size
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        holder.bindData(schools[position], clickListener)
    }
}