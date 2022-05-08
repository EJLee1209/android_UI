package com.example.myapplication

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityNetworkBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkAsyncTask().execute()

    }


}

class NetworkAsyncTask(): AsyncTask<Any?,Any?,Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString: String = "http://mellowcode.org/json/students/" //요청할 주소
        val url: URL = URL(urlString) //url 형태로 변환
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection // 연결
        connection.requestMethod = "GET" // requestMethod를 GET으로 설정
        connection.setRequestProperty("Content-Type", "application/json") // 키-밸류 형태로 요청 프로퍼티 설정

        var buffer = "" //데이터를 읽어서 저장할 버퍼
        if(connection.responseCode == HttpURLConnection.HTTP_OK){
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("testt", buffer)
        }
        return null
    }
}