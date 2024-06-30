package com.example.advancexox

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class ResultDialog(context: Context, private val message: String, private val mainActivity: MainActivity) :
    Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_dialog)

        val btnNavigate1: Button = findViewById(R.id.goToHomeButton)
        btnNavigate1.setOnClickListener{
            val intent1 = Intent(context, AddPlayers::class.java)
            context.startActivity(intent1)
        }

        val messageText = findViewById<TextView>(R.id.messageText)
        val startAgainButton = findViewById<Button>(R.id.startAgainButton)

        messageText.text = message

        startAgainButton.setOnClickListener {
            mainActivity.restartMatch()
            dismiss()
        }

    }
}