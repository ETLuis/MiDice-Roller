package com.dam2.andfun_kotlin_dice_roller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        var randomInt = SecureRandom()
        randomInt.setSeed(randomInt.generateSeed(6)+1)

        val drawableResource = when (randomInt) {
            1 -> R.drawable.ic_brujula
            2 -> R.drawable.ic_octopus
            3 -> R.drawable.ic_telefono
            4 -> R.drawable.ic_pelota_de_tenis
            5 -> R.drawable.ic_pelota_de_beisbol
            else -> R.drawable.empty_dice
        }

        diceImage.setImageResource(drawableResource)
    }
}