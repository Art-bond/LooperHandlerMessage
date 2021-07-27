package ru.d3st.looperhandlermessage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.tv_count)
        val btnStart = findViewById<Button>(R.id.btn_start)


        handler = Handler(Looper.getMainLooper())


        btnStart.setOnClickListener {
            handler?.removeCallbacksAndMessages(null)
            val now = SystemClock.uptimeMillis()
            for (i in 0..10) {
                val next = now + 1000 * i
                handler?.postAtTime(Runnable {
                    kotlin.run {
                        textView?.text = i.toString()
                    }
                }, next)

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)

    }
}
