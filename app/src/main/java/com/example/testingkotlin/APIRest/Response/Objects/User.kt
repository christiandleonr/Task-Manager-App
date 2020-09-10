package com.example.testingkotlin.APIRest.Response.Objects

import com.google.gson.annotations.SerializedName

class User(age: Int, name: String, email: String, createdAt: String, updatedAt: String) {
    @SerializedName("age")
    var age: Int? = age

    @SerializedName("name")
    var name: String? = name

    @SerializedName("email")
    var email: String? = email

    @SerializedName("createdAt")
    var createdAt: String? = createdAt

    @SerializedName("updatedAt")
    var updatedAt: String? = updatedAt
}