package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val backgroundTask = BackGroundAsyncTask(
            findViewById(R.id.progressBar),
            findViewById(R.id.progressBarText)
        )

        findViewById<TextView>(R.id.start).setOnClickListener{
            backgroundTask.execute()
        }
        findViewById<TextView>(R.id.stop).setOnClickListener{
            backgroundTask.cancel(true)
        }

        findViewById<TextView>(R.id.shoot).setOnClickListener{
            Log.d("testt", "SHOT!!!")
        }
    }
}

class BackGroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
    ) :AsyncTask<Int,Int,Int>(){
    // <Int,Int,Int> -> Params, Progress, Result
    // params -> doInbackGround 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입

    var percent: Int = 0
    override fun doInBackground(vararg p0: Int?): Int {
        // 백그라운드에서 할 작업
        while(isCancelled() == false){
            percent++
            if(percent > 100) break
            else{
                publishProgress(percent)
            }
            Thread.sleep(100)
        }
        return percent
    }

    override fun onPreExecute() {
        // 작업 시작 전에 할 작업
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun onPostExecute(result: Int?) {
        // 작업 시작 후에 할 작업
        progressText.text = "작업이 완료되었습니다."
    }

    override fun onProgressUpdate(vararg values: Int?) {
        // 진행중에 업데이트 하고싶은 부분
        progressbar.setProgress(values[0] ?: 0)
        progressText.text = "퍼센트 : " + values[0]
        super.onProgressUpdate(*values)
    }

    override fun onCancelled() {
        // 작업이 멈췄을 때 할 작업
        progressbar.setProgress(0)
        progressText.text = "작업이 취소되었습니다."
    }


}