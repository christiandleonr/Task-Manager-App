package com.example.testingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testingkotlin.APIRest.APIConnect
import com.example.testingkotlin.APIRest.NetworkHandler
import com.example.testingkotlin.APIRest.Request.ReqCreateTask
import com.example.testingkotlin.APIRest.Response.ResCreateTask
import com.example.testingkotlin.Fragments.CreateTaskFragment
import com.example.testingkotlin.Fragments.MenuFragment
import com.example.testingkotlin.Fragments.PasswordsFragment
import com.example.testingkotlin.Fragments.TasksFragment
import com.example.testingkotlin.Interfaces.CreateTaskInterface
import com.example.testingkotlin.Interfaces.MenuInterface
import com.example.testingkotlin.Interfaces.TasksInterface
import com.example.testingkotlin.Utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MenuInterface, TasksInterface, CreateTaskInterface {

    private lateinit var menuFragment: MenuFragment
    private lateinit var tasksFragment: TasksFragment
    private lateinit var passwordsFragment: PasswordsFragment
    private lateinit var createTaskFragment: CreateTaskFragment

    private val u: Utilities = Utilities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuFragment = MenuFragment()
        tasksFragment = TasksFragment()
        passwordsFragment = PasswordsFragment()
        createTaskFragment = CreateTaskFragment()

        u.replaceFragment(R.id.menuFragment, menuFragment, this)
        u.replaceFragment(R.id.passwordsAndTasks, tasksFragment, this)
    }

    override fun menuButtonsEvent(option: Int) {
        if (option == 1){
            u.replaceFragment(R.id.passwordsAndTasks, tasksFragment, this)
        } else if (option == 2) {
            u.replaceFragment(R.id.passwordsAndTasks, passwordsFragment, this)
        }
    }

    override fun createTask() {
        u.replaceFragment(
            R.id.passwordsAndTasks,
            createTaskFragment,
            this
        )
    }

    override fun back() {
        u.replaceFragment(R.id.passwordsAndTasks, tasksFragment, this)
    }

    override fun saveTask(name: String, description: String, completed: Boolean) {
        val token: String? = "Bearer " + u
            .getDataPreferences(this)
            .getString("token", "")

        val call: Call<ResCreateTask> = u
            .getAPIConnect()
            .createTask(token, ReqCreateTask(name, description, completed))

        call.enqueue(object: Callback<ResCreateTask>{
            override fun onResponse(call: Call<ResCreateTask>, response: Response<ResCreateTask>) {
                Log.i("logIn", "")
            }

            override fun onFailure(call: Call<ResCreateTask>, t: Throwable) {
                Log.e("logIn", t.message + t.cause)
            }
        })
    }
}
