package com.example.lolcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.allClear
import kotlinx.android.synthetic.main.activity_main.btnBackspace
import kotlinx.android.synthetic.main.activity_main.btnDivide
import kotlinx.android.synthetic.main.activity_main.btnDot
import kotlinx.android.synthetic.main.activity_main.btnEight
import kotlinx.android.synthetic.main.activity_main.btnEqual
import kotlinx.android.synthetic.main.activity_main.btnFive
import kotlinx.android.synthetic.main.activity_main.btnFour
import kotlinx.android.synthetic.main.activity_main.btnMinus
import kotlinx.android.synthetic.main.activity_main.btnMultiply
import kotlinx.android.synthetic.main.activity_main.btnNine
import kotlinx.android.synthetic.main.activity_main.btnOne
import kotlinx.android.synthetic.main.activity_main.btnPLus
import kotlinx.android.synthetic.main.activity_main.btnSeven
import kotlinx.android.synthetic.main.activity_main.btnSix
import kotlinx.android.synthetic.main.activity_main.btnThree
import kotlinx.android.synthetic.main.activity_main.btnTwo
import kotlinx.android.synthetic.main.activity_main.btnZero
import kotlinx.android.synthetic.main.activity_main.clear
import kotlinx.android.synthetic.main.activity_main.tvCurrentOperand
import kotlinx.android.synthetic.main.activity_main.tvInput
import kotlinx.android.synthetic.main.activity_main.tvOldInput

import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    var currentInput = StringBuilder()
    var currentOperator = Operator.NONE
    var operand1: BigDecimal? = null

    enum class Operator {
        NONE, ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set click listeners for number buttons
        btnOne.setOnClickListener { appendNumber("1") }
        btnTwo.setOnClickListener { appendNumber("2") }
        btnThree.setOnClickListener { appendNumber("3") }
        btnFour.setOnClickListener { appendNumber("4") }
        btnFive.setOnClickListener { appendNumber("5") }
        btnSix.setOnClickListener { appendNumber("6") }
        btnSeven.setOnClickListener { appendNumber("7") }
        btnEight.setOnClickListener { appendNumber("8") }
        btnNine.setOnClickListener { appendNumber("9") }
        btnZero.setOnClickListener { appendNumber("0") }
        btnDot.setOnClickListener { appendNumber(".") }
        // Set click listeners for operator buttons
        btnPLus.setOnClickListener { setOperator(Operator.ADD) }
        btnMinus.setOnClickListener { setOperator(Operator.SUBTRACT) }
        btnMultiply.setOnClickListener { setOperator(Operator.MULTIPLY) }
        btnDivide.setOnClickListener { setOperator(Operator.DIVIDE) }

        // Handle equals button click
        btnEqual.setOnClickListener { calculateResult() }

        // Handle clear button click
        clear.setOnClickListener { clearInput() }
        allClear.setOnClickListener { allClearInput() }

        //backSpace button
        btnBackspace.setOnClickListener { handleBackspace() }
    }
    private fun appendNumber(number: String) {
        currentInput.append(number)
        updateDisplay()
    }
    private fun handleBackspace() {
        if (currentInput.isNotEmpty()) {
            currentInput.deleteCharAt(currentInput.length - 1)
            updateDisplay()
        }
    }

    private fun setOperator(operator: Operator) {
        if (operand1 == null) {
            operand1 = BigDecimal(currentInput.toString())
            currentInput.clear()
        }
        tvOldInput.text = operand1.toString()
        tvInput.text = ""
        currentOperator = operator
        tvCurrentOperand.text = operatorToString(operator)
    }
    private fun operatorToString(operator: Operator): String {
        return when (operator) {
            Operator.ADD -> "+"
            Operator.SUBTRACT -> "-"
            Operator.MULTIPLY -> "×"
            Operator.DIVIDE -> "÷"
            Operator.NONE -> ""
        }
    }
    private fun calculateResult() {
        val operand2 = BigDecimal(currentInput.toString())
        var result: BigDecimal? = null
        Log.d("CalculatorApp", "operand1= ${operand1}")
        Log.d("CalculatorApp", "operand2= ${operand2}")
        Log.d("CalculatorApp", "currentInput= ${currentInput.toString()}")

        when (currentOperator) {
            Operator.ADD -> result = operand1?.add(operand2)
            Operator.SUBTRACT -> result = operand1?.subtract(operand2)
            Operator.MULTIPLY -> result = operand1?.multiply(operand2)
            Operator.DIVIDE -> {
                if (operand2 != BigDecimal.ZERO) {
                    result = operand1?.divide(operand2, 10, BigDecimal.ROUND_HALF_UP)
                }
            }
            Operator.NONE -> result = operand2
        }

        // Display the result and reset the state
        if (result != null) {
            tvOldInput.text = ("${operand1}${operatorToString(currentOperator)}${operand2}").toString()
            tvInput.text = result.toString()
            operand1 = result
        }
//        Log.d("CalculatorApp", "Result: ${result?.toString()}")

    }
    private fun allClearInput() {
        currentInput.clear()
        operand1 = null
        currentOperator = Operator.NONE
        tvOldInput.text = ""
        tvInput.text = "0"
        tvCurrentOperand.text = ""
    }
    private fun clearInput() {
        currentInput.clear()
        currentOperator = Operator.NONE
        tvInput.text = "0"
        operand1 = null
    }

    private fun updateDisplay() {
        tvInput.text = currentInput.toString()
    }
}