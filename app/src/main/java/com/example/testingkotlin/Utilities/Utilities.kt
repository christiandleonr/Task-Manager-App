package com.example.testingkotlin.Utilities

import android.app.Activity
import android.content.Context
import android.content.Intent

class Utilities {
    fun runStartActivity(packageContext: Context, activity: Activity, clazz: Class<*>){
        val intent: Intent = Intent(packageContext, clazz)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        packageContext.startActivity(intent)

        activity.finish()
    }
}