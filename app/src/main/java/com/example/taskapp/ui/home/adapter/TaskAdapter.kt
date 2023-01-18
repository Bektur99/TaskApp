package com.example.taskapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.databinding.ItemTaskBinding
import com.example.taskapp.ui.model.Task


class TaskAdapter : Adapter<TaskAdapter.TaskViewHolder>() {
    private val data = arrayListOf<Task>()

    fun addTask(task: Task) {
        data.add(0,task)
        notifyItemChanged(0)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTittle.text = task.tittle
            binding.tvDesc.text = task.desc
        }
    }

}