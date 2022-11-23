package com.example.chernomorcev

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val APP_PREFERENCE = "mysettings"
const val APP_PREFERENCE_EMAIL = "email"
const val APP_PREFERENCE_PAS = "password"
class MainActivity : AppCompatActivity()
{
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var butt : Button
    lateinit var button2 : Button
    private lateinit var settings : SharedPreferences
    var hasVisited : Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPassword)
        butt = findViewById(R.id.butt)
        button2 = findViewById(R.id.button2)

        settings = getSharedPreferences(APP_PREFERENCE_EMAIL, Context.MODE_PRIVATE)
        settings = getSharedPreferences(APP_PREFERENCE_PAS, Context.MODE_PRIVATE)
        hasVisited = settings.getBoolean("hasViisted", false)
        if(hasVisited == false){
            val x: SharedPreferences.Editor = settings.edit()
            x.putBoolean("hasVisited", true)
            x.apply()
            butt.visibility = View.VISIBLE
        }
        else {
            butt.visibility = View.VISIBLE
        }

        butt.setOnClickListener{
            var usemail = email.getText().toString()
            var uspassword = password.getText().toString()
            var prefEditor = settings.edit()
            prefEditor.putString(APP_PREFERENCE_EMAIL, usemail)
            prefEditor.putString(APP_PREFERENCE_PAS, uspassword)
            prefEditor.apply()
            var getemail = settings.getString(APP_PREFERENCE_EMAIL, "noLog")
            var getpassword = settings.getString(APP_PREFERENCE_PAS, "noPas")
            if(email.text.isEmpty() || password.text.isEmpty())
            {
                Toast.makeText(this,"Поля не заполнены!", Toast.LENGTH_LONG).show()
            }
            else
            {
                var intent = Intent(this,SecondMenu::class.java)
                startActivity(intent)
            }
        }
        button2.setOnClickListener{
            if(email.text.isEmpty() || password.text.isEmpty())
            {
                Toast.makeText(this,"Поля не заполнены!", Toast.LENGTH_LONG).show()
            }
            else
            {
                var intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }



    }




}