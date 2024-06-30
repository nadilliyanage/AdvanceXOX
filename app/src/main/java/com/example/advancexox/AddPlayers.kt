package com.example.advancexox

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.advancexox.databinding.ActivityAddPlayersBinding

class AddPlayers: AppCompatActivity() {

    private lateinit var binding: ActivityAddPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        binding = ActivityAddPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve highest score and display it
        val highestScore = getHighestScore()
        binding.highestScoreTextView.text = "Highest Score: $highestScore"

        // Add player button click listener
        binding.startGameButton.setOnClickListener {
            val playerOneName = binding.playerOne.text.toString()
            val playerTwoName = binding.playerTwo.text.toString()

            // Check if player names are not empty
            if (playerOneName.isNotEmpty() && playerTwoName.isNotEmpty()) {
                // Start MainActivity with player names
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("playerOne", playerOneName)
                intent.putExtra("playerTwo", playerTwoName)
                startActivity(intent)
            } else {
                // Show toast message to enter player names
                Toast.makeText(this, "Please enter player names", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getHighestScore(): Int {
        val sharedPreferences = getSharedPreferences("GameSettings", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("highestScore", 0) // Default value is 0 if no score is found
    }
}
