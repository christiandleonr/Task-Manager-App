package com.example.testingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testingkotlin.Fragments.MenuFragment
import com.example.testingkotlin.Fragments.PasswordsFragment
import com.example.testingkotlin.Fragments.TasksFragment
import com.example.testingkotlin.Interfaces.MenuInterface

class MainActivity : AppCompatActivity(), MenuInterface {

    private lateinit var menuFragment: MenuFragment
    private lateinit var tasksFragment: TasksFragment
    private lateinit var passwordsFragment: PasswordsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuFragment = MenuFragment()
        tasksFragment = TasksFragment()
        passwordsFragment = PasswordsFragment()

        replaceFragment(R.id.menuFragment, menuFragment)
        replaceFragment(R.id.passwordsAndTasks, tasksFragment)
    }

    override fun menuButtonsEvent(option: Int) {
        if (option == 1){
            replaceFragment(R.id.passwordsAndTasks, tasksFragment)
        } else if (option == 2) {
            replaceFragment(R.id.passwordsAndTasks, passwordsFragment)
        }
    }

    private fun replaceFragment(id: Int, fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(id, fragment)
            .commit()
    }
}
