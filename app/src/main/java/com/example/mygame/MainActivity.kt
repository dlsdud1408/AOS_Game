package com.example.mygame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var userChoiceImage: ImageView
    private lateinit var computerChoiceImage: ImageView
    private lateinit var resultText: TextView
    private val choices = arrayOf("Rock", "Paper", "Scissors")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userChoiceImage = findViewById(R.id.userChoiceImage)
        computerChoiceImage = findViewById(R.id.computerChoiceImage)
        resultText = findViewById(R.id.resultText)
    }

    fun onChoiceSelected(view: View) {
        val userChoice = when (view.id) {
            R.id.rockButton -> {
                userChoiceImage.setImageResource(R.drawable.rock)
                choices[0]
            }
            R.id.paperButton -> {
                userChoiceImage.setImageResource(R.drawable.paper)
                choices[1]
            }
            R.id.scissorsButton -> {
                userChoiceImage.setImageResource(R.drawable.scissors)
                choices[2]
            }
            else -> ""
        }

        val computerChoiceIndex = Random().nextInt(choices.size)
        val computerChoice = choices[computerChoiceIndex]
        computerChoiceImage.setImageResource(
            when (computerChoice) {
                "Rock" -> R.drawable.rock
                "Paper" -> R.drawable.paper
                else -> R.drawable.scissors
            }
        )

        val result = determineWinner(userChoice, computerChoice)

        resultText.text = result
    }



    private fun determineWinner(userChoice: String, computerChoice: String): String {
        if (userChoice == computerChoice) {
            return "It's a tie!"
        } else if (
            (userChoice == "Rock" && computerChoice == "Scissors") ||
            (userChoice == "Paper" && computerChoice == "Rock") ||
            (userChoice == "Scissors" && computerChoice == "Paper")
        ) {
            return "You win!"
        } else {
            return "Computer wins!"
        }
    }
}
