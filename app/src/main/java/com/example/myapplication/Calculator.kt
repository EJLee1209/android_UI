package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class Calculator : AppCompatActivity() {
    var number1: Int = 0
    var number2: Int = 0
    var sum: Int = 0
    var plusIsClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val number_text: TextView = findViewById(R.id.number)
        val btn_one: TextView = findViewById(R.id.btn_one)
        val btn_two: TextView = findViewById(R.id.btn_two)
        val btn_three: TextView = findViewById(R.id.btn_three)
        val btn_four: TextView = findViewById(R.id.btn_four)
        val btn_five: TextView = findViewById(R.id.btn_five)
        val btn_six: TextView = findViewById(R.id.btn_six)
        val btn_seven: TextView = findViewById(R.id.btn_seven)
        val btn_eight: TextView = findViewById(R.id.btn_eight)
        val btn_nine: TextView = findViewById(R.id.btn_nine)
        val btn_zero: TextView = findViewById(R.id.btn_zero)
        val btn_ca: TextView = findViewById(R.id.btn_ca)
        val btn_plus: TextView = findViewById(R.id.btn_plus)
        val btn_result: TextView = findViewById(R.id.btn_result)

        fun text_reset(){ //number 초기화(CA)
            number_text.setText("")
        }
        fun sum(a: Int, b: Int): Int{
            return a + b
        }

        fun setNumberTextViewLitener(){
            val numberTextViewList: List<TextView> = listOf(
                btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine
            )
            numberTextViewList.forEach {
                it.setOnClickListener {
                    number_text.setText(number_text.text.toString()+(it as TextView).text)
                }
            }
        }

        setNumberTextViewLitener()

        btn_zero.setOnClickListener {
            if(number_text.text.toString() != "")
                number_text.setText(number_text.text.toString()+(it as TextView).text)
        }

        btn_ca.setOnClickListener {
            text_reset()
        }

        btn_plus.setOnClickListener {
            if(!plusIsClicked){
                number1 = number_text.text.toString().toInt()
                text_reset()
            }
            plusIsClicked = true
        }
        btn_result.setOnClickListener {
            if(plusIsClicked && number_text.text != ""){
                number2 = number_text.text.toString().toInt()
                text_reset()
                sum = sum(number1, number2)
                number_text.setText(sum.toString())
                plusIsClicked = false
            }
        }

    }

}
