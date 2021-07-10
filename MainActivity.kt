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

        // Set a click listener on the button to flip the coin when the user taps the button
        flipButton.setOnClickListener { flipCoin() }
        val helloImage: ImageView = findViewById(R.id.imageView)
        helloImage.setImageResource(R.drawable.flip)
    }

    /**
     * Flip the coin and update the screen with the result.
     */
    private fun flipCoin() {
        // Create new Coin object with 2 sides and flip it
        val coin = Coin()
        val coinFlip = coin.flip()

        // Update the screen with the coin flip
        val coinImage: ImageView = findViewById(R.id.imageView)
        val drawableResource1 = when (coinFlip) {
            1 -> R.drawable.head
            else -> R.drawable.tail
        }
        coinImage.setImageResource(drawableResource1)
        coinImage.contentDescription = coinFlip.toString()
    }}

class Coin() {
    fun flip(): Int {
        return (1..2).random()
    }
}