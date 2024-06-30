package com.example.advancexox

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.advancexox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var boxPositions = IntArray(25)
    private var player1Score = 0
    private var player2Score = 0
    private var totalSelectedBoxes = 0
    private var highestScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getPlayerOneName = intent.getStringExtra("playerOne") ?: "Player 1"
        val getPlayerTwoName = intent.getStringExtra("playerTwo") ?: "Player 2"

        binding.playerOneName.text = getPlayerOneName
        binding.playerTwoName.text = getPlayerTwoName

        // Initialize scores
        updatePlayerScores()

        bindImageViews()
    }

    private fun bindImageViews() {
        val imageViews = listOf(
            binding.image1, binding.image2, binding.image3,
            binding.image4, binding.image5, binding.image6,
            binding.image7, binding.image8, binding.image9,
            binding.image10, binding.image11, binding.image12,
            binding.image13, binding.image14, binding.image15,
            binding.image16, binding.image17, binding.image18,
            binding.image19, binding.image20, binding.image21,
            binding.image22, binding.image23, binding.image24,
            binding.image25
        )
        imageViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                performAction(imageView as ImageView, index)
            }
        }
    }

    private fun performAction(imageView: ImageView, selectedBoxPosition: Int) {
        val currentPlayer = if (totalSelectedBoxes % 2 == 0) 1 else 2
        val currentPlayerSymbol = if (currentPlayer == 1) "X" else "O"

        // Check if the box position has already been selected
        if (boxPositions[selectedBoxPosition] != 0) {
            // Box position already selected, do nothing
            return
        }

        boxPositions[selectedBoxPosition] = currentPlayer

        imageView.setImageResource(if (currentPlayer == 1) R.drawable.ximage else R.drawable.oimage)

        // Check for winning sequences (XXX or OOO) in rows, columns, diagonals, and reverse diagonals
        if (checkForWinRowCol(currentPlayer)) {
            if (currentPlayer == 1) {
                player1Score++
            } else {
                player2Score++
            }
        }
        if (checkForWinDiagonal(currentPlayer)) {
            if (currentPlayer == 1) {
                player1Score++
            } else {
                player2Score++
            }
        }

        // Update scores display
        updatePlayerScores()

        totalSelectedBoxes++

        if (totalSelectedBoxes == 25) {
            determineWinner()
        }
    }
    private var a= 0;private var b= 0;private var c= 0;private var d= 0;private var e= 0;private var f= 0;
    private var g= 0;private var h= 0; private var i= 0;private var j= 0;private var k= 0;private var l= 0;
    private var m= 0;private var n= 0;private var o= 0;private var p= 0; private var q= 0;private var r= 0;
    private var s= 0;private var t= 0;private var u= 0;private var v= 0; private var w= 0;private var x= 0;
    private var y= 0;private var z= 0;private var aa= 0;private var ab= 0; private var ac= 0;private var ad= 0;
    private var ae= 0;private var af= 0;private var ag= 0;private var ah= 0; private var ai= 0;private var aj= 0;
    private var ak= 0;private var al= 0;private var am= 0;private var an= 0; private var ao= 0;private var ap= 0;
    private var aq= 0;private var ar= 0;private var au= 0;private var av= 0; private var aw= 0;private var ay= 0;

    private fun checkForWinRowCol(player: Int): Boolean {
        // Check rows

        if (a == 0 && boxPositions[0] == player && boxPositions[1] == player && boxPositions[2] == player) {
            a += 1
            return true

        }
        if (b == 0 && boxPositions[1] == player && boxPositions[2] == player && boxPositions[3] == player) {
            b += 1
            return true
        }
        if (c == 0 && boxPositions[2] == player && boxPositions[3] == player && boxPositions[4] == player) {
            c += 1
            return true
        }
        if (d == 0 && boxPositions[5] == player && boxPositions[6] == player && boxPositions[7] == player) {
            d += 1
            return true
        }
        if (e == 0 && boxPositions[6] == player && boxPositions[7] == player && boxPositions[8] == player) {
            e += 1
            return true
        }
        if (f == 0 && boxPositions[7] == player && boxPositions[8] == player && boxPositions[9] == player) {
            f += 1
            return true
        }
        if (g == 0 && boxPositions[10] == player && boxPositions[11] == player && boxPositions[12] == player) {
            g += 1
            return true
        }
        if (h == 0 && boxPositions[11] == player && boxPositions[12] == player && boxPositions[13] == player) {
            h += 1
            return true
        }
        if (i == 0 && boxPositions[12] == player && boxPositions[13] == player && boxPositions[14] == player) {
            i += 1
            return true
        }
        if (j == 0 && boxPositions[15] == player && boxPositions[16] == player && boxPositions[17] == player) {
            j += 1
            return true
        }
        if (k == 0 && boxPositions[16] == player && boxPositions[17] == player && boxPositions[18] == player) {
            k += 1;
            return true
        }
        if (l == 0 && boxPositions[17] == player && boxPositions[18] == player && boxPositions[19] == player) {
            l += 1
            return true
        }
        if (m == 0 && boxPositions[20] == player && boxPositions[21] == player && boxPositions[22] == player) {
            m += 1
            return true
        }
        if (n == 0 && boxPositions[21] == player && boxPositions[22] == player && boxPositions[23] == player) {
            n += 1
            return true
        }
        if (o == 0 && boxPositions[22] == player && boxPositions[23] == player && boxPositions[24] == player) {
            o += 1
            return true
        }

        // Check Columns
        if (p == 0 && boxPositions[0] == player && boxPositions[5] == player && boxPositions[10] == player) {
            p += 1
            return true
        }
        if (q == 0 && boxPositions[1] == player && boxPositions[6] == player && boxPositions[11] == player) {
            q += 1
            return true
        }
        if (r == 0 && boxPositions[2] == player && boxPositions[7] == player && boxPositions[12] == player) {
            r += 1
            return true
        }
        if (s == 0 && boxPositions[3] == player && boxPositions[8] == player && boxPositions[13] == player) {
            s += 1
            return true
        }
        if (t == 0 && boxPositions[4] == player && boxPositions[9] == player && boxPositions[14] == player) {
            t += 1
            return true
        }
        if (u == 0 && boxPositions[5] == player && boxPositions[10] == player && boxPositions[15] == player) {
            u += 1
            return true
        }
        if (v == 0 && boxPositions[6] == player && boxPositions[11] == player && boxPositions[16] == player) {
            v += 1
            return true
        }
        if (w == 0 && boxPositions[7] == player && boxPositions[12] == player && boxPositions[17] == player) {
            w += 1
            return true
        }
        if (x == 0 && boxPositions[8] == player && boxPositions[13] == player && boxPositions[18] == player) {
            x += 1
            return true
        }
        if (y == 0 && boxPositions[9] == player && boxPositions[14] == player && boxPositions[19] == player) {
            y += 1
            return true
        }
        if (z == 0 && boxPositions[10] == player && boxPositions[15] == player && boxPositions[20] == player) {
            z += 1
            return true
        }
        if (aa == 0 && boxPositions[11] == player && boxPositions[16] == player && boxPositions[21] == player) {
            aa += 1
            return true
        }
        if (ab == 0 && boxPositions[12] == player && boxPositions[17] == player && boxPositions[22] == player) {
            ab += 1
            return true
        }
        if (ac == 0 && boxPositions[13] == player && boxPositions[18] == player && boxPositions[23] == player) {
            ac += 1
            return true
        }
        if (ad == 0 && boxPositions[14] == player && boxPositions[19] == player && boxPositions[24] == player) {
            ad += 1
            return true
        }
        return false
    }

    private fun checkForWinDiagonal(player: Int): Boolean {
        // Check diagonal
        if (ae  == 0 && boxPositions[0] == player && boxPositions[6] == player && boxPositions[12] == player) {
            ae+=1
            return true
        }
        if (af  == 0 && boxPositions[1] == player && boxPositions[7] == player && boxPositions[13] == player) {
            af+=1
            return true
        }
        if (ag  == 0 && boxPositions[2] == player && boxPositions[8] == player && boxPositions[14] == player) {
            ag+=1
            return true
        }
        if (ah  == 0 && boxPositions[5] == player && boxPositions[11] == player && boxPositions[17] == player) {
            ah+=1
            return true
        }
        if (ai == 0 && boxPositions[6] == player && boxPositions[12] == player && boxPositions[18] == player) {
            ai+=1
            return true
        }
        if (aj == 0 && boxPositions[7] == player && boxPositions[13] == player && boxPositions[19] == player) {
            aj+=1
            return true
        }
        if (ak == 0 && boxPositions[10] == player && boxPositions[16] == player && boxPositions[22] == player) {
            ak+=1
            return true
        }
        if (al == 0 && boxPositions[11] == player && boxPositions[17] == player && boxPositions[23] == player) {
            al+=1
            return true
        }
        if (am == 0 && boxPositions[12] == player && boxPositions[18] == player && boxPositions[24] == player) {
            am+=1
            return true
        }


        // Check reverse diagonal
        if (an == 0 && boxPositions[4] == player && boxPositions[8] == player && boxPositions[12] == player) {
            an+=1
            return true
        }
        if (ao == 0 && boxPositions[3] == player && boxPositions[7] == player && boxPositions[11] == player) {
            ao+=1
            return true
        }
        if (ap == 0 && boxPositions[2] == player && boxPositions[6] == player && boxPositions[10] == player) {
            ap+=1
            return true
        }
        if (aq == 0 && boxPositions[9] == player && boxPositions[13] == player && boxPositions[17] == player) {
            aq+=1
            return true
        }
        if (ar == 0 && boxPositions[8] == player && boxPositions[12] == player && boxPositions[16] == player) {
            ar+=1
            return true
        }
        if (au == 0 && boxPositions[7] == player && boxPositions[11] == player && boxPositions[15] == player) {
            au+=1
            return true
        }
        if (av == 0 && boxPositions[14] == player && boxPositions[18] == player && boxPositions[22] == player) {
            av+=1
            return true
        }
        if (aw == 0 && boxPositions[13] == player && boxPositions[17] == player && boxPositions[21] == player) {
            aw+=1
            return true
        }
        if (ay == 0 && boxPositions[12] == player && boxPositions[16] == player && boxPositions[20] == player) {
            ay+=1
            return true
        }

        return false
    }

    private fun determineWinner() {
        val winner = if (player1Score > player2Score) {
            binding.playerOneName.text
        } else if (player2Score > player1Score) {
            binding.playerTwoName.text
        } else {
            "No one"
        }

        val getPlayerOneName = intent.getStringExtra("playerOne") ?: "Player 1"
        val getPlayerTwoName = intent.getStringExtra("playerTwo") ?: "Player 2"
        val resultDialog = ResultDialog(
            this,
            "$winner is a winner \n $getPlayerOneName - $player1Score\n $getPlayerTwoName - $player2Score",
            this
        )
        resultDialog.setCancelable(false)
        resultDialog.show()
    }

    private fun updatePlayerScores() {
        binding.playerOneScore.text = "Score: $player1Score"
        binding.playerTwoScore.text = "Score: $player2Score"

        // Get the current highest score
        val highestScore = getHighestScore()

        // Update the highest score if the current game's highest score is greater
        val currentHighestScore = maxOf(player1Score, player2Score)
        if (currentHighestScore > highestScore) {
            saveHighestScore(currentHighestScore)
        }
    }


    // Function to save highest score
    private fun saveHighestScore(score: Int) {
        val sharedPreferences = getSharedPreferences("GameSettings", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("highestScore", score)
        editor.apply()
    }

    // Function to retrieve highest score
    private fun getHighestScore(): Int {
        val sharedPreferences = getSharedPreferences("GameSettings", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("highestScore", 0)
    }

    fun restartMatch() {
        val intent = intent
        finish()
        startActivity(intent)
    }
}
