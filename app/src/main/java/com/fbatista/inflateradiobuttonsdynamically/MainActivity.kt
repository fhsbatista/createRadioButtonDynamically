package com.fbatista.inflateradiobuttonsdynamically

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val radioGroup: RadioGroup by lazy {
        val radioGroup = RadioGroup(this)
        radioGroup.orientation = LinearLayout.VERTICAL
        radioGroup
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultList = listOf(
            RadioButtonItem("alskdf", "Primeira opção"),
            RadioButtonItem("kasdf9892", "Segunda opção"),
            RadioButtonItem("askdjf982s", "Terceira opção")
        )

        setupRadioButtons(defaultList)
        createBtn.setOnClickListener { addRadioButton(RadioButtonItem("9384234", "Novo RadioButton")) }
    }

    private fun setupRadioButtons(list: List<RadioButtonItem>) {
        containerRg.addView(radioGroup)
        list.forEach { addRadioButton(it) }
    }

    private fun addRadioButton(item: RadioButtonItem) {
        val newRadioButton = RadioButton(this)
        newRadioButton.id = View.generateViewId()
        newRadioButton.text = item.text
        radioGroup.addView(newRadioButton)
    }
}

data class RadioButtonItem(val id: String,
                           val text: String)
