package com.example.activity_homework_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible

const val TAG = "MainActivity"
const val EXTRA_MESSAGE = "com.example.activity_homework_2.extra.MESSAGE"


class MainActivity : AppCompatActivity() {

    private var editTextMessage: EditText? = null
    private var replyHeaderTextView: TextView? = null
    private var replyText: TextView? = null

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                // There are no request codes
                replyHeaderTextView?.visibility = View.VISIBLE
                val reply = result.data?.getStringExtra(EXTRA_REPLY)
                replyText?.text = reply
                replyText?.visibility = View.VISIBLE

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMessage = findViewById(R.id.ed_text_main_activity)
        replyHeaderTextView = findViewById(R.id.header_reply)
        replyText = findViewById(R.id.textView_reply_message)
    }

    fun launchSecondActivity(view: View) {
        Log.d(TAG, "Button clicked")
        val message = editTextMessage?.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
            .putExtra(EXTRA_MESSAGE, message)
        resultLauncher.launch(intent)
    }

}