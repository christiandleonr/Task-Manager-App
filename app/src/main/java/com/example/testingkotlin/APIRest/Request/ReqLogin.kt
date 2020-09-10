package com.example.testingkotlin.APIRest.Request

import com.google.gson.annotations.SerializedName

class ReqLogin(email: String, password: String) {
    @SerializedName("email")
    var email: String? = email

    @SerializedName("password")
    var password: String? = password
}