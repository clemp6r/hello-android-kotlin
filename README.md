Android Hello World with Kotlin
===============================

This project is a POC for showing how to integrate the **Kotlin** language in an Android project. It includes a mix of Java and Kotlin source code, with a working Maven configuration and Android Studio / IntelliJ project files.

What is Kotlin?
---------------
Kotlin is a programming language developed by JetBrains. It can be compiled to JVM bytecode (and even Javascript), so it can be used in any Java program.

See: http://kotlin.jetbrains.org/

Why using Kotlin with Android?
------------------------------
Mainly for functional programming.

Currently there is no official plan to support Java 8 and its lambdas on Android. Scala is a good candidate, but at the time of writing, its integration with Android is a pain due to its very large runtime. That's why I tried Kotlin.

Sample code
-----------
```
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
        textView.setText(getString(R.string.hello_message, SomeJavaClass.getItWorksMessage()));

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
```

How to enable Kotlin in a Maven Android project?
-------------
It's just a matter of getting the right Maven configuration: see the pom.xml file if you need details.
In a few words, here are the requirements:

* Enable the Kotlin build plugin for Maven
* Add the Kotlin library dependency
* Adding repositories is required as the Kotlin dependencies are still snapshots
* We need build-helper-maven-plugin to include src/main/kotlin as a source folder
* As a workaround to a known interoperability problem between the Kotlin and the Android maven plugins, we need maven-antrun-plugin to create a missing target folder automatically (see http://youtrack.jetbrains.com/issue/KT-3679).

Prerequisites to run this project
-------------
* Maven 3.1.1
* Android SDK 19

Using Android Studio
--------------------
All Android Studio project files are already under source control: just open the project with Android Studio.
By default you will have a run configuration named "Launch Kotlin activity" that will build and launch the application on your device or emulator.

Build with Maven
----------------
Run the following command to build the APK with Maven:

    $ mvn package

Limitations
-----------
There may be some.