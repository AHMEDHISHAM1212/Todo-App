package com.example.noteapplication.ui.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.database.TasksDatabase
import com.example.noteapplication.databinding.FragmentAddTaskBinding
import com.example.noteapplication.model.Task
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddTaskBottomFragment: BottomSheetDialogFragment() {
    private lateinit var viewBinding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAddTaskBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.btnSubmit.setOnClickListener{
            createTask()
        }
    }

    private fun createTask() {
        if (!valid()){
            return
        }
        else{
            // create task
            val task = Task(
                title = viewBinding.etTitle.text.toString(),
                description = viewBinding.etContent.text.toString()
            )
            TasksDatabase.getInstance(requireContext())
                .tasksDao()
                .insertTask(task)
            onAddedTasksListener?.onAddedTask()
            dismiss()
        }
    }

    var onAddedTasksListener: OnAddedTasksListener?= null
    fun interface OnAddedTasksListener{
        fun onAddedTask()
    }
    private fun valid(): Boolean {
        var isValid = true
        if (viewBinding.etTitle.text.toString().isNullOrBlank()){
            viewBinding.titleContainer.error = "Please enter the title"
            isValid = false
        }else{
            viewBinding.titleContainer.error = null
        }

        if (viewBinding.etContent.text.toString().isNullOrBlank()){
            viewBinding.contentContainer.error = "Please enter the title"
            isValid = false
        }else{
            viewBinding.contentContainer.error = null
        }
        return isValid
    }
}