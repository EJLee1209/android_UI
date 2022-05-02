package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.get

class HomeworkActivity_addView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_add_view)

        val personList = mutableListOf<Person>()
        for (i in 1..10){
            personList.add(Person("${i}번째 사람", "010-1111-111${i}"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.homework_container)
        val inflater = LayoutInflater.from(this)
        personList.forEach { person ->

            val personListView = inflater.inflate(R.layout.person_list,null)
            val personImage = personListView.findViewById<ImageView>(R.id.person_image)
            val nthPerson = personListView.findViewById<TextView>(R.id.nthPerson)
            val nthPhoneNumber = personListView.findViewById<TextView>(R.id.nthPhoneNumber)

            personImage.setImageDrawable(resources.getDrawable(R.drawable.blue_background,this.theme))
            nthPerson.text = person.nthPerson
            nthPhoneNumber.text = person.nthPhoneNumber

            container.addView(personListView)

            personListView.setOnClickListener {
                startActivity(
                    Intent(this, PersonActivity::class.java).apply{
                        this.putExtra("name", person.nthPerson)
                        this.putExtra("number", person.nthPhoneNumber)
                    }
                )
            }
        }


    }
}

class Person(val nthPerson: String, val nthPhoneNumber: String)