package com.example.testingkotlin.APIRest.Response

import android.content.ClipDescription
import com.google.gson.annotations.SerializedName

class ResCreateTask(completed: Boolean, description: String, createdAt: String, updatedAt:String) {
    @SerializedName("completed")
    private var completed: Boolean? = completed

    @SerializedName("description")
    private var description: String? = description

    @SerializedName("createdAt")
    private var createdAt: String? = createdAt

    @SerializedName("updatedAt")
    private var updatedAt: String? = updatedAt
}