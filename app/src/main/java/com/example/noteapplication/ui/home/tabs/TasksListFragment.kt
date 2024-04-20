package com.example.noteapplication.ui.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noteapplication.databinding.FragmentTasksListBinding

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
}