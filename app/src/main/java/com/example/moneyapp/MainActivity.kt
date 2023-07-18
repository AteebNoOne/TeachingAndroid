package com.example.moneyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timerTask
//First we need timer which is prebuilt library in kotlin
//We can easily import by hovering the item and it sugegst to import only if the library exists
//now we need the fix raet as +1 per second it sugegst all the options you can try them
//to run the timerTask we have a prebuilt keyword to use Threads so we going to run it on UI thread
//Now we need to assign time in Ms
class MainActivity : AppCompatActivity() {
    //Now lets import the button here
    //First we need to set constraints of button too

    private lateinit var money : TextView
    private lateinit var withDrawButton : Button //Button got automatically imported
    private var value_money = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        money = findViewById(R.id.textView) //forgot to initialize money
        withDrawButton = findViewById(R.id.withdraw) // initialization

        withDrawButton.isEnabled = false // I disabled it as you told me a condition

        val timer = Timer()
        timer.scheduleAtFixedRate(
            timerTask {
                runOnUiThread{
                    value_money +=2
                        //So here we were incrementing the value of money so we have to put the condition
                    //here to enable our withdraw button
                    //So here we put the condition that
                    if(value_money > 10){
                        withDrawButton.isEnabled = true//So here we are going to enable the button on this condition
                    }

                    //Thats really very easyy condition lets run it
                    money.text = "$value_money"
                }

            },0,5000 )


    }
}