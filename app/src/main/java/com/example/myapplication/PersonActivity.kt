package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        val intent = intent
        val name: String? = intent.extras?.getString("name") ?: ""
        val number: String? = intent.extras?.getString("number") ?: ""

        findViewById<TextView>(R.id.text_nthPerson).text = name
        findViewById<TextView>(R.id.text_nthPhoneNumber).text = number

    }
}