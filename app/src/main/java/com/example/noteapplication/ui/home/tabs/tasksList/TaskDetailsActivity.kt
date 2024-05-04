package com.example.noteapplication.ui.home.tabs.tasksList

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapplication.databinding.ActivityTasksDetailsBinding
import com.example.noteapplication.model.Constant
import com.example.noteapplication.model.Task

class TaskDetailsActivity: AppCompatActivity() {
    private lateinit var viewBinding: ActivityTasksDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityTasksDetailsBinding
            .inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        initPrams()
        bindTask()

    }

    private fun bindTask() {
        viewBinding.contentTaskDetails
           .etTitleEdit.append(task?.title)
        viewBinding.contentTaskDetails
            .etDescEdit.append(task?.description)
    }

    private var task: Task?= null

    // receive data from previous fragment.
    private fun initPrams() {
        // receive data from previous fragment.
        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constant.EXTRA_TASK, Task::class.java)
        } else {
            intent.getParcelableExtra(Constant.EXTRA_TASK) as Task?
        }
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBarLayout)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}