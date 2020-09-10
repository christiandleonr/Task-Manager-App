package com.example.testingkotlin.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.testingkotlin.Interfaces.MenuInterface

import com.example.testingkotlin.R


class MenuFragment : Fragment(), View.OnClickListener {
    private var menuInterface: MenuInterface? = null
    private lateinit var passwordButton: ImageButton
    private lateinit var taskButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordButton = view.findViewById(R.id.passwordButton)
        passwordButton.setOnClickListener(this)

        taskButton = view.findViewById(R.id.taskButton)
        taskButton.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MenuInterface){
            menuInterface = context
        }
    }

    override fun onDetach() {
        super.onDetach()

        menuInterface = null
    }

    override fun onClick(v: View?) {
        if (v == taskButton){
            menuInterface?.menuButtonsEvent(1)
        }else if (v == passwordButton){
            menuInterface?.menuButtonsEvent(2)
        }
    }

}
