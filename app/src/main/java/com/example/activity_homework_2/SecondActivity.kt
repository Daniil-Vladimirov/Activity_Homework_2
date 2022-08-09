package com.example.activity_homework_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val EXTRA_REPLY = "com.example.activity_homework_2.extra.REPLY"

class SecondActivity : AppCompatActivity() {

    private var replyTextMessage: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        replyTextMessage = findViewById(R.id.ed_text_second_activity)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView_message)
        textView.text = message
    }

    fun returnReply(view: View) {
        Log.d(TAG, "Reply clicked")
        val replyMessage = replyTextMessage?.text.toString()
        val intent = Intent()
            .putExtra(EXTRA_REPLY, replyMessage)
        setResult(RESULT_OK, intent)
        finish()

    }
}