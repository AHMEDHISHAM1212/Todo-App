package com.example.noteapplication.ui.home.tabs.tasksList

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noteapplication.database.TasksDatabase
import com.example.noteapplication.databinding.FragmentTasksListBinding
import com.example.noteapplication.model.Constant
import com.example.noteapplication.model.Task

class TasksListFragment: Fragment() {

    private lateinit var viewBinding: FragmentTasksListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasksListBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        loadTask()
    }

    fun loadTask() {
        // when we use bottom sheet in the the another context if the context = null do not do any thing
        context.let {it
            var tasks = TasksDatabase.getInstance(it!!)
                .tasksDao()
                .getAllTasks()

            adapter.bindTasks(tasks)
        }

    }

    private val adapter = TasksAdapter(null)
    private fun initViews() {
        viewBinding.rvNoteList.adapter = adapter
        initAdapterClick()
    }

    private fun initAdapterClick() {
      adapter.onItemClickListener = TasksAdapter.OnItemClickListener{_, task ->
          passTaskToTaskDetailsAct(task)
      }
    }

    private fun passTaskToTaskDetailsAct(task: Task) {
        val intent =Intent(requireContext(),TaskDetailsActivity::class.java)
        intent.putExtra(Constant.EXTRA_TASK,task)
        startActivity(intent)
    }

}