package com.example.myapplication

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MasterApplication : Application(){
    // 모든 액티비티의 라이프 사이클을 확인 할 수 있다
    // 애플리케이션이 실행되는 동안 계속 살아있는 Application Context
    // 어플이 실행되는 동안에만 저장할 데이터들을 이곳에 저장해도 된다

    val userId = 1000
    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object: Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d("testt", "onActivityCreated")
            }

            override fun onActivityStarted(p0: Activity) {
                Log.d("testt", "onActivityStarted")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d("testt", "onActivityResumed")
            }

            override fun onActivityPaused(p0: Activity) {
                Log.d("testt", "onActivityPaused")
            }

            override fun onActivityStopped(p0: Activity) {
                Log.d("testt", "onActivityStopped")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d("testt", "onActivitySaveInstanceState")
            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d("testt", "onActivityDestroyed")
            }
        })




    }
    fun methodFromApplication(){
        Log.d("testt","methodFromApplication")
    }


}