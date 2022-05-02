package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Intent_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        val intent = intent // Intent_one에서 putExtra해준 intent를 가져옴
        // 인텐트가 넘어올지 안넘어올지 모르므로 nullable
        val data: String? = intent.extras?.getString("extra-data") // putExtra()할때 value로 넘겨준 값의 자료형에 따라 다름
                                                                            // - String -> getString, byte -> getByte()....
        if(data != null){
            Log.d("dataa", data)
        }

        (findViewById<TextView>(R.id.finish)).apply{
            this.setOnClickListener {
                val intent: Intent = Intent()
                intent.putExtra("result","success")
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        imageView.setImageURI(uri)

    }
}