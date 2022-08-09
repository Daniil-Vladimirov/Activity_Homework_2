package com.example.activity_homework_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

const val TAG = "MainActivity"
const val EXTRA_MESSAGE = "com.example.activity_homework_2.extra.MESSAGE"

class MainActivity : AppCompatActivity() {

    private var editTextMessage: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMessage = findViewById<EditText>(R.id.ed_text_main_activity)
    }

    fun launchSecondActivity(view: View) {
        val message = editTextMessage?.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
            .putExtra(EXTRA_MESSAGE, message)
        Log.d(TAG, "Button clicked")
        startActivity(intent)
    }
}