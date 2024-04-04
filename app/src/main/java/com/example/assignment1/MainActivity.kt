package com.example.assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.headingTextView)

        val tableNumberEditText = findViewById<EditText>(R.id.tableNumberEditText)
        val matchButton = findViewById<Button>(R.id.matchButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        matchButton.setOnClickListener {
            val ageString = tableNumberEditText.text.toString()
            if (ageString.isNotEmpty()) {
                val age = ageString.toInt()
                val matchedFigure = findMatchedHistoricalFigure(age)
                if (matchedFigure != null) {
                    resultTextView.text = "At age $age, ${matchedFigure.name} died."
                } else {
                    resultTextView.text = "No famous historical figure found who died."
                }
            } else {
                resultTextView.text = "Please enter your age."
            }
        }
    }


    private fun findMatchedHistoricalFigure(age: Int): HistoricalFigure? {
        val figures = listOf(
            HistoricalFigure("Wolfgang Amadeus Mozart", 35),
            HistoricalFigure ("Lawrence Bragg", 25),
            HistoricalFigure ("Nadia Comeneci", 14),
            HistoricalFigure ("Nellie Bly", 23),
            HistoricalFigure ("Ida B. Wells", 27),
            HistoricalFigure ("William Pitt", 24),
        )
        return figures.find { it.age == age }
    }
}

data class HistoricalFigure(val name: String, val age: Int)
