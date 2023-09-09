# LOL_Calculator

# Simple Calculator App with Complex UI in Android Studio Using Kotlin

## Introduction

Welcome to the Simple Calculator App with Complex UI tutorial. In this tutorial, we will guide you through the process of creating a basic calculator app for Android using the Kotlin programming language and Android Studio. By the end of this tutorial, you will have a functional calculator app that can perform basic arithmetic operations.

## Prerequisites

Before you start, make sure you have the following:

- [Android Studio](https://developer.android.com/studio) installed on your computer.
- Basic knowledge of the Kotlin programming language.

## Getting Started

### Step 1: Create a New Android Project

1. Open Android Studio and click on "Start a new Android Studio project" or select "File" > "New" > "New Project."

2. Choose an appropriate project template (e.g., "Empty Activity" or "Basic Activity") and click "Next."

3. Configure your project by providing a name, package name, and other details. Click "Finish" to create the project.

### Step 2: Design the Calculator Layout

1. In the "res" folder of your project, navigate to "layout" and open the "activity_main.xml" layout file.

2. Design your calculator interface by adding buttons for numbers (0-9), arithmetic operators (+, -, *, /), a clear button (C), an equals button (=), and a TextView to display input and results.

Here's a sample layout XML that you can use as a reference:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="#4d4d4d"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:layout_marginTop="50dp"
        android:paddingVertical="50dp">
        <TextView
            android:id="@+id/tvOldInput"
            android:layout_width="match_parent"
            android:layout_gravity="center"
            android:textColor="@color/green"
            android:gravity="right|center_vertical"
            android:layout_height="50dp"
            android:textSize="25dp"
            android:paddingHorizontal="30dp"
            android:text=""/>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/tvCurrentOperand"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_gravity="center"
                android:textSize="30dp"
                android:gravity="center_vertical|left"
                android:paddingLeft="50dp"
                android:text="" />

            <TextView
                android:id="@+id/tvInput"
                android:layout_width="wrap_content"
                android:layout_gravity="center"
                android:gravity="right|center_vertical"
                android:layout_height="50dp"
                android:textSize="40dp"
                android:textColor="@color/white"
                android:paddingHorizontal="30dp"
                android:text="0"/>
        </LinearLayout>


    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/allClear"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="AC" />

        <Button
            android:id="@+id/clear"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="C" />


        <ImageButton
            android:id="@+id/btnBackspace"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="center"
            android:layout_weight="5"
            android:background="#4d4d4d"
            android:src="@drawable/img_backspace" />

        <Button
            android:id="@+id/btnDivide"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="30dp"
            android:background="#4d4d4d"
            android:textColor="@color/green"
            android:text="÷" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnSeven"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="7" />

        <Button
            android:id="@+id/btnEight"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="8" />

        <Button
            android:id="@+id/btnNine"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="9" />

        <Button
            android:id="@+id/btnMultiply"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="#4d4d4d"
            android:textColor="@color/green"
            android:textSize="30dp"
            android:text="×" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnFour"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="4" />

        <Button
            android:id="@+id/btnFive"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="5" />

        <Button
            android:id="@+id/btnSix"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="6" />

        <Button
            android:id="@+id/btnMinus"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="30dp"
            android:background="#4d4d4d"
            android:textColor="@color/green"
            android:text="-" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnOne"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="1" />

        <Button
            android:id="@+id/btnTwo"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="2" />

        <Button
            android:id="@+id/btnThree"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="3" />

        <Button
            android:id="@+id/btnPLus"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="30dp"
            android:background="#4d4d4d"
            android:textColor="@color/green"
            android:text="+" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnDot"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="." />

        <Button
            android:id="@+id/btnZero"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:textSize="20dp"
            android:background="#4d4d4d"
            android:text="0" />



        <Button
            android:id="@+id/btnEqual"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="8"
            android:textSize="20dp"
            android:background="@color/orange"
            android:text="=" />
    </LinearLayout>
</LinearLayout>
```

### Step 3: Implement the Calculator Logic

1. Open the "MainActivity.kt" file.

2. Define variables for your user interface elements, such as TextView and buttons, at the top of your `MainActivity` class.

```kotlin
// Define variables for UI elements
val tvInput = findViewById<TextView>(R.id.tvInput)
val btnOne = findViewById<Button>(R.id.btnOne)
val btnTwo = findViewById<Button>(R.id.btnTwo)
// Add similar declarations for other buttons

// Initialize currentInput as a StringBuilder
var currentInput = StringBuilder()
```

3. Create functions to handle button clicks, such as appending numbers, setting operators, calculating results, and clearing input.

```kotlin
// Function to append numbers to the current input
private fun appendNumber(number: String) {
  currentInput.append(number)
  updateDisplay()
}

// Function to set the current operator
private fun setOperator(operator: String) {
  if (currentInput.isNotEmpty()) {
    // If input is not empty, set the operator and clear the input
    currentInput.clear()
    // Update the display to show the current operator
  }
}

// Function to calculate results
private fun calculateResult() {
  if (currentInput.isNotEmpty()) {
    val operand2 = currentInput.toString().toDouble()
    var result = 0.0 // Initialize the result
    // Determine the current operator and perform the calculation
    when (currentOperator) {
      "+" -> result = operand1 + operand2
      "-" -> result = operand1 - operand2
      "*" -> result = operand1 * operand2
      "/" -> result = operand1 / operand2
    }
    // Update the result
    currentInput.clear()
    currentInput.append(result.toString())
    // Update the display with the result
    updateDisplay()
  }
}

// Function to clear input
private fun clearInput() {
  currentInput.clear()
  // Clear the display
  updateDisplay()
}

// Function to update the display
private fun updateDisplay() {
  tvInput.text = currentInput.toString()
}
```

### Step 4: Implement Operator and Calculation Logic

1. Extend your code to handle operator buttons (+, -, *, /), the equals button (=), and clear (C).

2. Implement the logic for performing arithmetic operations based on the user's input. Use a `when` statement to determine the current operator and perform the calculation accordingly.

```kotlin
// Function to set the current operator
private fun setOperator(operator: String) {
  if (currentInput.isNotEmpty()) {
    // If input is not empty, set the operator and clear the input
    currentInput.clear()
    // Update the display to show the current operator
  }
}

// Function to calculate results
private fun calculateResult() {
  if (currentInput.isNotEmpty()) {
    val operand2 = currentInput.toString().toDouble()
    var result = 0.0 // Initialize the result
    // Determine the current operator and perform the calculation
    when (currentOperator) {
      "+" -> result = operand1 + operand2
      "-" -> result = operand1 - operand2
      "*" -> result = operand1 * operand2
      "/" -> result = operand1 / operand2
    }
    // Update the result
    currentInput.clear()
    currentInput.append(result.toString())
    // Update the display with the result
    updateDisplay()
  }
}

// Function to clear input
private fun clearInput() {
  currentInput.clear()
  // Clear the display
  updateDisplay()
}
```

### Step 5: Set Click Listeners

In the "onCreate" method of your "MainActivity," set click listeners for your buttons to call the corresponding functions.

```kotlin
// Set click listeners for number buttons
btnOne.setOnClickListener { appendNumber("1") }
btnTwo.setOnClickListener { appendNumber("2") }
// Add click listeners for other number buttons

// Set click listeners for operator buttons
btnAdd.setOnClickListener { setOperator("+") }
btnSubtract.setOnClickListener { setOperator("-") }
btnMultiply.setOnClickListener { setOperator("*") }
btnDivide.setOnClickListener { setOperator("/") }

// Handle equals button click
btnEqual.setOnClickListener { calculateResult() }

// Handle clear button click
btnClear.setOnClickListener { clearInput() }
```

### Step 6: Test Your Calculator App

1. Run your app on an Android emulator or physical device to test its functionality.

2. Verify that you can input numbers, perform calculations, and clear the input as expected.

## Conclusion

Congratulations! You've created a simple calculator app in Android using Kotlin. This tutorial covers the basics of building a calculator user interface and implementing arithmetic operations. You can further enhance your app by adding features like decimal points, handling edge cases, and improving the user interface.

For the full tutorial, visit the [tutorial website](https://www.sjbtechcenter.online/projects/build-a-simple-calculator-app-with-complex-ui-in-android-studio-using-kotlin).

If you have any questions or encounter any problems, feel free to [contact the author](mailto:soubhagyajitborah@gmail.com).

Happy coding!

