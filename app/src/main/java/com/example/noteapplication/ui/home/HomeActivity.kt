package com.example.noteapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.databinding.ActivityHomeBinding
import com.example.noteapplication.ui.home.tabs.AddTaskBottomFragment
import com.example.noteapplication.ui.home.tabs.SettingsFragment
import com.example.noteapplication.ui.home.tabs.tasksList.TasksListFragment
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    private var tasksListFragmentRef: TasksListFragment?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initBottomNavClicks()
        initFabClick()
    }

    private fun initFabClick() {
        viewBinding.fabAdd.setOnClickListener{
            showAddTasksBottomFragment()
        }
    }

    private fun showAddTasksBottomFragment() {
        val addTaskFragment = AddTaskBottomFragment()
        addTaskFragment.onAddedTasksListener = AddTaskBottomFragment.OnAddedTasksListener {
            Snackbar.make(viewBinding.root,"Note added successfully.",Snackbar.LENGTH_LONG)
                .show()
            //notify the fragment , new task added
            tasksListFragmentRef?.loadTask()
        }
        addTaskFragment.show(supportFragmentManager,"")
    }

    private fun initBottomNavClicks() {
        viewBinding.bottomNav.background = null

        viewBinding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_tasks_list ->{
                    tasksListFragmentRef = TasksListFragment()
                    showFragment(tasksListFragmentRef!!)
                }
                R.id.nav_tasks_settings ->{
                    showFragment(SettingsFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        viewBinding.bottomNav.selectedItemId = R.id.nav_tasks_list
    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()

    }
}