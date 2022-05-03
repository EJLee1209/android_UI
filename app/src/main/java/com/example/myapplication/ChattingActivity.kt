package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChattingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatting)
        //데이터를 준비
        val chattingList = mutableListOf<Person2>()
        for(i in 0..33){
            chattingList.add(
                Person2("안녕하세요",1)
            )
            chattingList.add(
                Person2("네 안녕하세요",2)
            )
            chattingList.add(
                Person2("반갑습니다",1)
            )
            chattingList.add(
                Person2("네 반갑습니다",2)
            )
            chattingList.add(
                Person2("안녕히주무세요",1)
            )
            chattingList.add(
                Person2("네 안녕히주무세요",2)
            )
        }



        val recyclerView = findViewById<RecyclerView>(R.id.chatting_list)
        recyclerView.adapter = RecyclerViewAdapter2(chattingList, LayoutInflater.from(this), this)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}
class RecyclerViewAdapter2(
    val chattingList: MutableList<Person2>,
    val inflater: LayoutInflater,
    val context: Context
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemViewType(position: Int): Int {
        return chattingList[position].multi_type
    }

    inner class ViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView){
        val chattingImage: ImageView
        val chattingText: TextView

        init{
            chattingImage = itemView.findViewById(R.id.chatting_image)
            chattingText = itemView.findViewById(R.id.chatting_text)
        }
    }
    inner class ViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView){
        val chattingImage2: ImageView
        val chattingText2: TextView

        init{
            chattingImage2 = itemView.findViewById(R.id.chatting_image2)
            chattingText2 = itemView.findViewById(R.id.chatting_text2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when(viewType){
            1 -> {
                view = inflater.inflate(R.layout.chatting_list, parent, false)
                ViewHolder1(view)
            }
            else -> {
                view = inflater.inflate(R.layout.chatting_list2, parent, false)
                ViewHolder2(view)
            }
        }

    }



    override fun getItemCount(): Int {
        return chattingList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(chattingList[position].multi_type){
            1 -> {
                (holder as ViewHolder1).chattingImage.setImageDrawable(
                    context.getDrawable(R.drawable.blue_background)
                )
                (holder as ViewHolder1).chattingText.text = chattingList[position].text
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as ViewHolder2).chattingImage2.setImageDrawable(
                    context.getDrawable(R.drawable.yellow_background)
                )
                (holder as ViewHolder2).chattingText2.text = chattingList[position].text
                holder.setIsRecyclable(false)
            }
        }
    }
}



class Person2(val text: String, val multi_type: Int)






