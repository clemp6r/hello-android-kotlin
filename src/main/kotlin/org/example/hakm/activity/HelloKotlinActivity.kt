package org.example.hakm.activity

import android.os.Bundle
import android.app.Activity
import org.example.hakm.R
import android.widget.TextView
import org.example.hakm.SomeJavaClass

public open class HelloKotlinActivity() : Activity() {

    protected override fun onCreate(savedInstanceState : Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_kotlin_activity)

        val view = findViewById(R.id.textView) as TextView
        view.setText(getString(R.string.hello_message, SomeJavaClass.getItWorksMessage()));
    }
}
