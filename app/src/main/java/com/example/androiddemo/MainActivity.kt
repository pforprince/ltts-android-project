package com.example.androiddemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var usernameTv = findViewById<TextView>(R.id.username)
        var nameTv = findViewById<TextView>(R.id.name)
        var passwordTv = findViewById<TextView>(R.id.password)
        var genderTv = findViewById<TextView>(R.id.gender)
        var countryTv = findViewById<TextView>(R.id.country)
        var expertiseTv = findViewById<TextView>(R.id.expertise)
        val sharedPreference = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        usernameTv.text = "Username is " + sharedPreference.getString("username", "")
        nameTv.text = "Name is " + sharedPreference.getString("name", "")
        passwordTv.text = "Password is " + sharedPreference.getString("password", "")
        genderTv.text = "Gender is " + sharedPreference.getString("gender", "")
        countryTv.text = "Country is " + sharedPreference.getString("country", "")
        expertiseTv.text = "Expertise is " + sharedPreference.getString("expertise", "")
    }

}