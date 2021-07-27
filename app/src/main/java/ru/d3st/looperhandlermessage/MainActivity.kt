package ru.d3st.looperhandlermessage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tv_count)
        val btnStart = findViewById<Button>(R.id.btn_start)


        val handler = Handler(Looper.getMainLooper())


        btnStart.setOnClickListener {
            for (i in 0..10) {
                handler.postDelayed(Runnable {
                    kotlin.run {
                        textView.text = i.toString()
                    }
                }, (1000 * i).toLong())
            }
        }
    }
}