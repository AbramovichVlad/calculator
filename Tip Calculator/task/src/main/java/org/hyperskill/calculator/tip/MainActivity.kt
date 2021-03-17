package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                setValue()
            }

        })

        slider.addOnChangeListener { slider, value, fromUser ->
            setValue()
        }
    }

    private fun setValue() {
        if (!edit_text.text.isEmpty()) {
            val coast = edit_text.text.toString().toDouble()
            val resault = coast * slider.value / 100
            val decimalResault = String.format("%.2f", resault)

            text_view.setText("Tip amount: $decimalResault")
        }
    }
}