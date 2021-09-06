package com.example.androiddemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usernameTv = findViewById<TextView>(R.id.username)
        val nameTv = findViewById<TextView>(R.id.name)
        val passwordTv = findViewById<TextView>(R.id.password)
        val genderTv = findViewById<TextView>(R.id.gender)
        val countryTv = findViewById<TextView>(R.id.country)
        val expertiseTv = findViewById<TextView>(R.id.expertise)
        val logout = findViewById<Button>(R.id.logout)
        val sharedPreference = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        usernameTv.text = "Username is " + sharedPreference.getString("username", "")
        nameTv.text = "Name is " + sharedPreference.getString("name", "")
        passwordTv.text = "Password is " + sharedPreference.getString("password", "")
        genderTv.text = "Gender is " + sharedPreference.getString("gender", "")
        countryTv.text = "Country is " + sharedPreference.getString("country", "")
        expertiseTv.text = "Expertise is " + sharedPreference.getString("expertise", "")

        logout.setOnClickListener(View.OnClickListener {
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        })
    }

}