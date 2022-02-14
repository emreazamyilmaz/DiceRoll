package com.cotlus.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.cotlus.diceroll.databinding.ActivityMainBinding
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.rollButton.setOnClickListener { rollDice() }
        rollDice()
    }
}

private fun rollDice() {
    val diceRandom = Dice(6)
    val diceRollOne = diceRandom.roll()
    val diceRollTwo = diceRandom.roll()
    val diceImageFirst: ImageView = binding.diceFirst
    val diceImageSecond: ImageView = binding.diceSecond

    val drawableResourceOne = when (diceRollOne) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val drawableResourceTwo = when (diceRollTwo) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    diceImageFirst.setImageResource(drawableResourceOne)
    diceImageFirst.contentDescription = diceRollOne.toString()
    diceImageSecond.setImageResource(drawableResourceTwo)
    diceImageSecond.contentDescription = diceRollTwo.toString()
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}