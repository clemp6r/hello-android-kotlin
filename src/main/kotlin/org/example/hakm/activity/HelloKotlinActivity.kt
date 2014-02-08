package org.example.hakm.activity

import android.os.Bundle
import android.app.Activity
import org.example.hakm.R
import android.widget.TextView
import org.example.hakm.SomeJavaClass
import android.widget.Button

class HelloKotlinActivity() : Activity() {

    var clicks = 0

    protected override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_kotlin_activity)

        val textView = findViewById(R.id.textView) as TextView
        textView.setText(getString(R.string.hello_message, SomeJavaClass.getItWorksMessage()))

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { textView.setText(getMessage()) }
    }

    fun getMessage(): String {
        when(++clicks) {
            1    -> return "You clicked once"
            2    -> return "You clicked twice"
            else -> return "You clicked $clicks times"
        }
    }
}
