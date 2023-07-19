package com.example.moneyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.concurrent.timerTask
//First we need timer which is prebuilt library in kotlin
//We can easily import by hovering the item and it sugegst to import only if the library exists
//now we need the fix raet as +1 per second it sugegst all the options you can try them
//to run the timerTask we have a prebuilt keyword to use Threads so we going to run it on UI thread
//Now we need to assign time in Ms

class MainActivity : AppCompatActivity() {

    private lateinit var money: TextView
    private lateinit var withDrawButton: Button
    private var value_money = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        money = findViewById(R.id.textView)
        withDrawButton = findViewById(R.id.withdraw)
        withDrawButton.isEnabled = false

        val timer = Timer()
        timer.scheduleAtFixedRate(
            timerTask {
                runOnUiThread {
                    value_money += 2
                    if (value_money > 10) {
                        withDrawButton.isEnabled = true
                    }
                    money.text = "$value_money"
                }
            }, 0, 5000
        )

        withDrawButton.setOnClickListener {
            WithdrawNotification()
        }
    }

    private fun WithdrawNotification() {
        val message = "You withdrew Rs. $value_money successfully"
        val b = AlertDialog.Builder(this)
        b.setMessage(message)
        b.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val alertDialog = b.create()
        alertDialog.show()
    }
}