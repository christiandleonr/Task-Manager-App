package com.example.testingkotlin.APIRest

import com.example.testingkotlin.APIRest.Request.ReqLogin
import com.example.testingkotlin.APIRest.Request.ReqRegister
import com.example.testingkotlin.APIRest.Response.ResLogin
import com.example.testingkotlin.APIRest.Response.ResRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header

import retrofit2.http.Headers
import retrofit2.http.POST

interface APIConnect {
    @Headers("Content_type: application/json")
    @POST("users/login")
    fun loginUser(@Body reqUser: ReqLogin): Call<ResLogin>

    @Headers("Content_type: application/json")
    @POST("users")
    fun createUser(@Body reqRegister: ReqRegister): Call<ResRegister>
}