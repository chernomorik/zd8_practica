package com.example.chernomorcev

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class Profile : AppCompatActivity() {

    lateinit var buttfindweather : Button
    lateinit var user_field : EditText
    lateinit var result_info : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        buttfindweather=findViewById(R.id.findweather)
        user_field = findViewById(R.id.city2)
        result_info = findViewById(R.id.info)
        buttfindweather.setOnClickListener{
            if(user_field.getText().toString().trim().equals(""))
            {
                Toast.makeText(this,"Поля не заполнены!", Toast.LENGTH_LONG).show()
            }
            else
            {
                val city = user_field.getText().toString()
                val key = "c8feede2eae1941cf3b8350a0742d216"
                val url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key + "&units=metric&lang=ru"

            }

        }
    }





}