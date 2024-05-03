package com.example.noteapplication.ui.home.tabs.tasksList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.databinding.ItemTaskBinding
import com.example.noteapplication.model.Task

class TasksAdapter(var tasksList: List<Task>?= null):
    RecyclerView.Adapter<TasksAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinging = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(itemBinging)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasksList!![position])

        if(onItemClickListener!=null){
            holder.itemBinging.root
                .setOnClickListener{
                    onItemClickListener!!
                        .onItemClick(position = position , task = tasksList!![position])
                }
        }
    }

    override fun getItemCount(): Int = tasksList!!.size
    fun bindTasks(tasks: List<Task>) {
        this.tasksList =tasks
        notifyDataSetChanged()

    }
    var onItemClickListener: OnItemClickListener?= null

    fun interface OnItemClickListener{
        fun onItemClick(position: Int , task: Task)
    }


    class ViewHolder(val itemBinging: ItemTaskBinding): RecyclerView.ViewHolder(itemBinging.root){
        fun bind(task: Task){
            itemBinging.tvTitle.text = task.title
            itemBinging.tvDesc.text = task.description
        }
    }
}
