package com.dogukanincee.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ddd.androidutils.DoubleClick
import com.ddd.androidutils.DoubleClickListener
import com.itis.libs.parserng.android.expressParser.MathExpression
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    //Calculator Buttons
    private lateinit var buttonDot: Button
    private lateinit var button0: Button
    private lateinit var buttonPi: Button
    private lateinit var buttonPlus: Button
    private lateinit var buttonEqual: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonClear: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonParentheses: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonSqrt: Button
    private lateinit var buttonExponent: Button
    private lateinit var buttonFactorial: Button
    private lateinit var buttonLogLn: Button
    private lateinit var buttonE: Button

    //Calculator textViews
    private lateinit var equation: TextView
    private lateinit var result: TextView
    private lateinit var buttonBackspace: ImageButton

    //Variables of equation
    private lateinit var display: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize buttons
        buttonDot = findViewById(R.id.buttonDot)
        button0 = findViewById(R.id.button0)
        buttonPi = findViewById(R.id.buttonPi)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonEqual = findViewById(R.id.buttonEqual)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonClear = findViewById(R.id.buttonClear)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonParentheses = findViewById(R.id.buttonParentheses)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonSqrt = findViewById(R.id.buttonSqrt)
        buttonExponent = findViewById(R.id.buttonExponent)
        buttonFactorial = findViewById(R.id.buttonFactorial)
        buttonLogLn = findViewById(R.id.buttonLogLn)
        buttonE = findViewById(R.id.buttonE)
        buttonBackspace = findViewById(R.id.buttonBackspace)

        //Initialize textViews
        equation = findViewById(R.id.textViewEquation)
        result = findViewById(R.id.textViewResult)

        //Initialize variables
        display = ""

        //OnClickMethods of buttons
        onClickMethods()

    }

    @SuppressLint("SetTextI18n")
    private fun onClickMethods() {

        //When 0 is clicked, add 0 on the equation and remove result text since the equation is not over
        button0.setOnClickListener {
            display += "0"
            equation.text = display
            result.text = null
        }

        //When 1 is clicked, add 1 on the equation and remove result text since the equation is not over
        button1.setOnClickListener {
            display += "1"
            equation.text = display
            result.text = null
        }

        //When 2 is clicked, add 2 on the equation and remove result text since the equation is not over
        button2.setOnClickListener {
            display += "2"
            equation.text = display
            result.text = null
        }

        //When 3 is clicked, add 3 on the equation and remove result text since the equation is not over
        button3.setOnClickListener {
            display += "3"
            equation.text = display
            result.text = null
        }

        //When 4 is clicked, add 4 on the equation and remove result text since the equation is not over
        button4.setOnClickListener {
            display += "4"
            equation.text = display
            result.text = null
        }

        //When 5 is clicked, add 5 on the equation and remove result text since the equation is not over
        button5.setOnClickListener {
            display += "5"
            equation.text = display
            result.text = null
        }

        //When 6 is clicked, add 6 on the equation and remove result text since the equation is not over
        button6.setOnClickListener {
            display += "6"
            equation.text = display
            result.text = null
        }


        //When 7 is clicked, add 7 on the equation and remove result text since the equation is not over
        button7.setOnClickListener {
            display += "7"
            equation.text = display
            result.text = null
        }


        //When 8 is clicked, add 8 on the equation and remove result text since the equation is not over
        button8.setOnClickListener {
            display += "8"
            equation.text = display
            result.text = null
        }

        //When 9 is clicked, add 9 on the equation and remove result text since the equation is not over
        button9.setOnClickListener {
            display += "9"
            equation.text = display
            result.text = null
        }


        //When . is clicked, add . on the equation and remove result text since the equation is not over
        buttonDot.setOnClickListener {
            display += "."
            equation.text = display
            result.text = null
        }

        //When pi is clicked, add pi on the equation and remove result text since the equation is not over
        buttonPi.setOnClickListener {
            display += "π"
            equation.text = display
            result.text = null
        }

        //When + is clicked, add + on the equation and remove result text since the equation is not over
        buttonPlus.setOnClickListener {
            display += "+"
            equation.text = display
            result.text = null
        }

        //When - is clicked, add - on the equation and remove result text since the equation is not over
        buttonMinus.setOnClickListener {
            display += "-"
            equation.text = display
            result.text = null
        }

        //When * is clicked, add * on the equation and remove result text since the equation is not over
        buttonMultiply.setOnClickListener {
            display += "*"
            equation.text = display
            result.text = null
        }

        //When % is clicked, add % on the equation and remove result text since the equation is not over
        buttonDivide.setOnClickListener {
            display += "÷"
            equation.text = display
            result.text = null
        }

        //When equal is clicked,
        buttonEqual.setOnClickListener {
            try {
                if (display != "") {
                    val resultNumber: Double? =
                        MathExpression(display.replace("÷", "/")).solve()?.toDouble()
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.HALF_EVEN
                    result.text = df.format(resultNumber)
                } else result.text = ""
            } catch (e: Exception) {
                result.text = "SYNTAX ERROR"
            }
        }

        //When parentheses is clicked, put parentheses respectively
        buttonParentheses.setOnClickListener {
            var open = 0
            var closed = 0
            display.indices.forEach { i ->
                if (display.startsWith("(", i)) open++
                if (display.startsWith(")", i)) closed++
            }
            println("Open: $open")
            println("Close: $closed")
            when {
                open == closed || display.endsWith("(") -> display += "("
                open > closed && !display.substring(
                    display.length - 1
                ).equals("") -> display += ")"
            }
            equation.text = display
            result.text = null
        }

        //When . is clicked, add . on the equation and remove result text since the equation is not over
        buttonLogLn.setOnClickListener(doubleClick)
        buttonLogLn.setOnLongClickListener {
            display += "ln("
            equation.text = display
            result.text = null
            true
        }

        //When e is clicked, add e on the equation and remove result text since the equation is not over
        buttonE.setOnClickListener {
            display += "e"
            equation.text = display
            result.text = null
        }


        //When . is clicked, add . on the equation and remove result text since the equation is not over
        buttonSqrt.setOnClickListener {
            display += "sqrt("
            equation.text = display
            result.text = null
        }

        //When ^ is clicked, add ^ on the equation and remove result text since the equation is not over
        buttonExponent.setOnClickListener {
            display += "^"
            equation.text = display
            result.text = null
        }

        //When fact is clicked, add fact on the equation and remove result text since the equation is not over
        buttonFactorial.setOnClickListener {
            display += "fact("
            equation.text = display
            result.text = null
        }

        //When clear is clicked, clear the equation
        buttonClear.setOnClickListener {
            display = ""
            equation.text = display
            result.text = display
        }

        //When backspace is clicked, remove the last character from the equation
        buttonBackspace.setOnClickListener {
            if (display.isNotEmpty()) {
                display = display.substring(0, display.length - 1)
                equation.text = display
                result.text = null
            }
        }

    }

    //Listener for double click action
    private val doubleClick = DoubleClick(object : DoubleClickListener {

        //If button is clicked once, add log on the equation
        override fun onSingleClickEvent(view: View?) {
            display += "log("
            equation.text = display
            result.text = null
        }

        //If button is clicked twice, add ln on the equation
        override fun onDoubleClickEvent(view: View?) {
            display += "ln("
            equation.text = display
            result.text = null
        }
    })
}