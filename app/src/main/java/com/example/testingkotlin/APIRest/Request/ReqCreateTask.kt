package com.example.testingkotlin.APIRest.Request

import com.google.gson.annotations.SerializedName

class ReqCreateTask(name: String, description: String, completed: Boolean) {
    @SerializedName("name")
    private var name: String? = name

    @SerializedName("description")
    private var description: String? = description

    @SerializedName("completed")
    private var completed: Boolean? = completed
}