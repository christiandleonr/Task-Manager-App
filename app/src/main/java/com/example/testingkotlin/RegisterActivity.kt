package com.example.testingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testingkotlin.APIRest.APIConnect
import com.example.testingkotlin.APIRest.NetworkHandler
import com.example.testingkotlin.APIRest.Request.ReqRegister
import com.example.testingkotlin.APIRest.Response.ResRegister
import com.example.testingkotlin.Utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    private lateinit var signUp: Button

    private lateinit var backToLogIn: TextView

    private val networkHandler: NetworkHandler = NetworkHandler()
    private val apiConnect: APIConnect = networkHandler
        .getRetrofit()
        .create(APIConnect::class.java)

    private val utilities: Utilities = Utilities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullName = findViewById(R.id.editFullName)
        email = findViewById(R.id.editEmailRegister)
        password = findViewById(R.id.editPasswordRegister)

        signUp = findViewById(R.id.buttonSigIn)
        signUp.setOnClickListener(this)

        backToLogIn = findViewById(R.id.textViewBackToLogin)
        backToLogIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == signUp){
            signUp()
        }else if (v == backToLogIn){
            utilities.runStartActivity(
                this@RegisterActivity,
                this@RegisterActivity,
                LoginActivity::class.java
            )
        }
    }

    private fun signUp(){
        val fullName: String = fullName.text.toString()
        val email: String = email.text.toString()
        val password: String = password.text.toString()

        val call: Call<ResRegister> = apiConnect
            .createUser(ReqRegister(fullName, email, password))

        call.enqueue(object: Callback<ResRegister>{
            override fun onResponse(call: Call<ResRegister>, response: Response<ResRegister>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<ResRegister>, t: Throwable) {
                Log.e("logIn", t.message + t.cause)
            }
        })
    }

}
