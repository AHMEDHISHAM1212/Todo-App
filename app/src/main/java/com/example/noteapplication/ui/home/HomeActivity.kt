package com.example.noteapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.noteapplication.R
import com.example.noteapplication.databinding.ActivityHomeBinding
import com.example.noteapplication.ui.home.tabs.SettingsFragment
import com.example.noteapplication.ui.home.tabs.TasksListFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initBottomNavClicks()
    }

    private fun initBottomNavClicks() {
        viewBinding.bottomNav.background = null

        viewBinding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_tasks_list ->{
                    showFragment(TasksListFragment())
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