package com.example.testingkotlin.APIRest.Response

import com.example.testingkotlin.APIRest.Response.Objects.User
import com.google.gson.annotations.SerializedName

class ResRegister(token: String, user: User) {
    @SerializedName("token")
    var token: String? = token

    @SerializedName("user")
    var user: User? = user
}