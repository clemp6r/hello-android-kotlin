hello-android-kotlin
====================

This project is a demo for showing how to integrate the **Kotlin** language in an Android project.
The application can be built with Maven, and can also be opened in Android Studio.

What is Kotlin?
---------------
Kotlin is a programming language developed by JetBrains. It can be compiled to JVM bytecode, so it can be used in any Java program.
See: http://kotlin.jetbrains.org/

Why using Kotlin with Android?
------------------------------
Mainly for functional programming.

Currently the official Android application language is Java 6. Java 7 support is limited, and there is no official plan to support Java 8 and its lambdas. Scala could be the solution, but at the time of writing, its integration with Android is a pain due to its very large runtime. That's why I wanted to try using Kotlin to make an Android app.

How does it work?
-------------
It's just a matter of getting the right Maven configuration: have a look the pom.xml file to get the answer.
To summarize, here are the requirements:

* Enable the Kotlin build plugin for Maven
* Add the Kotlin library dependency
* Adding repositories is required as the Kotlin dependencies are still snapshots
* We need build-helper-maven-plugin to include src/main/kotlin as a source folder
* As a workaround to a known interoperability problem between the Kotlin and the Android maven plugins, we need maven-antrun-plugin to create a missing target folder automatically (see http://youtrack.jetbrains.com/issue/KT-3679).

Prerequisites
-------------
* Maven 3.1.1
* Android SDK 19

Using Android Studio
--------------------
All Android Studio project files are already under source control: just open the project with Android Studio.
By default you have a run configuration named "Launch Kotlin activity" that will build and launch the application on your device or emulator.

Build with Maven
----------------
Run the following command to build the APK with Maven:

    $ mvn package