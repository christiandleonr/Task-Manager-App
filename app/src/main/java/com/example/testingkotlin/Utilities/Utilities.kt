package com.example.testingkotlin.Utilities

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testingkotlin.APIRest.APIConnect
import com.example.testingkotlin.APIRest.NetworkHandler

class Utilities {
    fun runStartActivity(packageContext: Context, activity: Activity, clazz: Class<*>){
        val intent: Intent = Intent(packageContext, clazz)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        packageContext.startActivity(intent)

        activity.finish()
    }

    fun replaceFragment(id: Int, fragment: Fragment, appCompatActivity: AppCompatActivity){
        appCompatActivity.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(id, fragment)
            .commit()
    }

    fun getAPIConnect(): APIConnect{
        val networkHandler: NetworkHandler = NetworkHandler()
        return networkHandler
            .getRetrofit()
            .create(APIConnect::class.java)
    }

    fun getEditor(contextWrapper: ContextWrapper): SharedPreferences.Editor =
        contextWrapper.getSharedPreferences("data", Context.MODE_PRIVATE).edit()

    fun getDataPreferences(contextWrapper: ContextWrapper): SharedPreferences =
        contextWrapper.getSharedPreferences("data", Context.MODE_PRIVATE)
}