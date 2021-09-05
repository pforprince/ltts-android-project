package com.example.androiddemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginButton = findViewById<Button>(R.id.logInButton)
        var signUpButton = findViewById<Button>(R.id.signUpButton)
        var usernameEt = findViewById<TextInputEditText>(R.id.userNameEt)
        var passwordEt = findViewById<TextInputEditText>(R.id.passwordEt)
        val sharedPreference = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        var username = sharedPreference.getString("username", "")
        var password = sharedPreference.getString("password", "")
        var passwordText = ""
        if (!isEmpty(username))
            usernameEt.setText(username)
        if (!isEmpty(password))
            passwordEt.setText(password)
        signUpButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        })
        loginButton.setOnClickListener(View.OnClickListener {
            passwordText = passwordEt.text.toString()
            if (usernameEt.text.toString().isEmpty())
                Toast.makeText(applicationContext, "Username Empty", Toast.LENGTH_SHORT)
                    .show()
            else if (!password.equals(passwordText)) {
                Toast.makeText(applicationContext, "Password Is Not Correct", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })

    }
}