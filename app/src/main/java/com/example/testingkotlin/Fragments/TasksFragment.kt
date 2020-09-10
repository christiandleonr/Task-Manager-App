package com.example.testingkotlin.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testingkotlin.Interfaces.TasksInterface

import com.example.testingkotlin.R
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class TasksFragment : Fragment() {
    private var tasksInterface: TasksInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is TasksInterface){
            tasksInterface = context
        }
    }


    override fun onDetach() {
        super.onDetach()

        tasksInterface = null
    }

}
