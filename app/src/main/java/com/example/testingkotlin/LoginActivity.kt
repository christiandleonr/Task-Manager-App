package com.example.testingkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testingkotlin.APIRest.APIConnect
import com.example.testingkotlin.APIRest.NetworkHandler
import com.example.testingkotlin.APIRest.Request.ReqLogin
import com.example.testingkotlin.APIRest.Response.ResLogin
import com.example.testingkotlin.Utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var logIn: Button
    private lateinit var signIn: TextView

    private val networkHandler: NetworkHandler = NetworkHandler()
    private val apiConnect: APIConnect = networkHandler
        .getRetrofit()
        .create(APIConnect::class.java)

    private val utilities: Utilities = Utilities()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.editEmail)
        password = findViewById(R.id.editPassword)

        logIn = findViewById(R.id.buttonLogIn)
        logIn.setOnClickListener(this)
        signIn = findViewById(R.id.textViewSingIn)
        signIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == logIn){
            logIn()
        }else if (v == signIn){
            utilities.runStartActivity(
                this@LoginActivity,
                this@LoginActivity,
                RegisterActivity::class.java
            )
        }
    }

    @SuppressLint("CommitPrefEdits")
    private fun logIn(){
        val editor: SharedPreferences.Editor = getEditor()

        val email: String = email.text.toString()
        val password: String = password.text.toString()

        val call: Call<ResLogin> = apiConnect.loginUser(ReqLogin(email, password))

        call.enqueue(object: Callback<ResLogin> {
            override fun onResponse(call: Call<ResLogin>, response: Response<ResLogin>) {
                if(response.isSuccessful){
                    response.body()?.token?.let { editor.putString("token", it) }

                    response.body()?.user?.name.let { editor.putString("name", it) }
                    response.body()?.user?.age?.let { editor.putInt("age", it) }
                    response.body()?.user?.email?.let { editor.putString("email", it) }

                    utilities.runStartActivity(
                        this@LoginActivity,
                        this@LoginActivity,
                        MainActivity::class.java
                    )

                    Log.i("logIn", "")
                }
            }

            override fun onFailure(call: Call<ResLogin>, t: Throwable) {
                Log.e("logIn", t.message + t.cause)
            }
        })
    }

    private fun getEditor(): SharedPreferences.Editor =
        getSharedPreferences("data", Context.MODE_PRIVATE).edit()
}
