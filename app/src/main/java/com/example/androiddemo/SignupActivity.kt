package com.example.androiddemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SignupActivity : AppCompatActivity() {
    var name = ""
    var userName = ""
    var pass = ""
    var gender = ""
    var expertise = ""
    var country = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        var userNameLay = findViewById<TextInputLayout>(R.id.userNameLayout)
        var userNameEt = findViewById<TextInputEditText>(R.id.userNameEt)
        var nameLay = findViewById<TextInputLayout>(R.id.nameLayout)
        val nameEt = findViewById<TextInputEditText>(R.id.nameEt)
        var passLay = findViewById<TextInputLayout>(R.id.passwordLayout)
        val passEt = findViewById<TextInputEditText>(R.id.passwordEt)
        val spinner = findViewById<Spinner>(R.id.spinner);
        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        var appCheck = findViewById<CheckBox>(R.id.appCheck)
        var webCheck = findViewById<CheckBox>(R.id.webCheck)
        var signUpButton = findViewById<Button>(R.id.signUpButton)
        var loginButton = findViewById<Button>(R.id.logInButton)
        val sharedPreference = getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)

        val spinnerArray =
            arrayOf<String>("Select your country", "India", "USA", "Canada", "Others");
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, spinnerArray)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(aa)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.maleRadio -> {
                    gender = findViewById<RadioButton>(R.id.maleRadio).text.toString()
                }
                R.id.feMaleRadio -> {
                    gender = findViewById<RadioButton>(R.id.feMaleRadio).text.toString()
                }

            }
        })
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                if (position != 0)
                    country = spinnerArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        signUpButton.setOnClickListener(View.OnClickListener {
            name = nameEt.text.toString()
            userName = userNameEt.text.toString()
            pass = passEt.text.toString()
            if (webCheck.isChecked)
                expertise += webCheck.text.toString()
            if (appCheck.isChecked)
                expertise += appCheck.text.toString()
            var editor = sharedPreference.edit()
            editor.putString("username", userName)
            editor.putString("name", name)
            editor.putString("password", pass)
            editor.putString("country", country)
            editor.putString("gender", gender)
            editor.putString("expertise", expertise)
            editor.apply()
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)


        })
        loginButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        })
    }


}