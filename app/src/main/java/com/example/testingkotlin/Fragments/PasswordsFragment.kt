package com.example.testingkotlin.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testingkotlin.Interfaces.PasswordsInterface

import com.example.testingkotlin.R

/**
 * A simple [Fragment] subclass.
 */
class PasswordsFragment : Fragment() {

    private var passwordsInterface: PasswordsInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_passwords, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is PasswordsInterface){
            passwordsInterface = context
        }
    }

    override fun onDetach() {
        super.onDetach()

        passwordsInterface = null
    }
}
