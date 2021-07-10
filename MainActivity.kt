package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Find the Button in the layout
        val flipButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        flipButton.setOnClickListener { flipCoin() }
        val helloImage: ImageView = findViewById(R.id.imageView)
        helloImage.setImageResource(R.drawable.flip)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun flipCoin() {
        // Create new Dice object with 6 sides and roll it
        val coin = Coin()
        val coinFlip = coin.flip()

        // Update the screen with the 1st dice roll
        val coinImage: ImageView = findViewById(R.id.imageView)
        val drawableResource1 = when (coinFlip) {
            1 -> R.drawable.head
            else -> R.drawable.tail
        }
        coinImage.setImageResource(drawableResource1)
        coinImage.contentDescription = coinFlip.toString()
    }}
/**
 * Dice with a fixed number of sides.
 */
class Coin() {

    /**
     * Do a random dice roll and return the result.
     */
    fun flip(): Int {
        return (1..2).random()
    }


}