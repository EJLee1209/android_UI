package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // savedInstanceState : 사용자가 남기고간 이전 상태를 복원하거나 저장하기 위해서 사용되는 파라미터
        setContentView(R.layout.activity_01) //화면을 그려준다
        // 한번만 하면 되는 작업
        Log.d("LifeCycle" , "onCreate")
    }
    override fun onStart() {
        Log.d("LifeCycle" , "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LifeCycle" , "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle" , "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LifeCycle" , "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LifeCycle" , "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d("LifeCycle" , "onRestart")
        super.onRestart()
    }
}