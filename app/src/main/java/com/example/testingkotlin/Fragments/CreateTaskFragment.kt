package com.example.testingkotlin.Fragments

import android.content.ClipDescription
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Switch
import com.example.testingkotlin.Interfaces.CreateTaskInterface

import com.example.testingkotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CreateTaskFragment : Fragment(), View.OnClickListener {
    private var createTaskInterface: CreateTaskInterface? = null

    private lateinit var buttonBack: FloatingActionButton
    private lateinit var buttonSave: FloatingActionButton

    private lateinit var editTaskName: EditText
    private lateinit var editDescription: EditText

    private lateinit var switchCompleted: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBack = view.findViewById(R.id.buttonBack)
        buttonSave = view.findViewById(R.id.buttonSave)

        editTaskName = view.findViewById(R.id.editTaskName)
        editDescription = view.findViewById(R.id.editDescription)

        switchCompleted = view.findViewById(R.id.switchCompleted)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is CreateTaskInterface){
            createTaskInterface = context
        }
    }

    override fun onDetach() {
        super.onDetach()

        createTaskInterface = null
    }

    override fun onClick(v: View?) {
        if (v == buttonBack){
            createTaskInterface?.back()
        }else if (v == buttonSave){
            saveTask()
        }
    }

    private fun saveTask(){
        val name: String = editTaskName.text.toString()
        val description: String = editDescription.text.toString()
        val completed: Boolean? = switchCompleted.isActivated

        if (completed != null) {
            createTaskInterface?.saveTask(name, description, completed)
        }
    }
}
