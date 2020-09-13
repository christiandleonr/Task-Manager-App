package com.example.testingkotlin.Interfaces

interface CreateTaskInterface: ActionsInterface {
    fun saveTask(name: String, description: String, completed: Boolean)
}