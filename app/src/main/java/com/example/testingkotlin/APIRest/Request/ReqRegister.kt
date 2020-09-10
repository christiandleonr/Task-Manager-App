package com.example.testingkotlin.APIRest.Request

import com.google.gson.annotations.SerializedName

class ReqRegister(name: String, email: String, password: String) {
    @SerializedName("name")
    var name: String? = name

    @SerializedName("email")
    var email: String? = email

    @SerializedName("password")
    var password: String? = password
}