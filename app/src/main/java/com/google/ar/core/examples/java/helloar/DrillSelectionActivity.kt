package com.google.ar.core.examples.java.helloar

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DrillSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_selection)

        val spinner = findViewById<Spinner>(R.id.drill_spinner)
        val desc = findViewById<TextView>(R.id.drill_description)
        val tips = findViewById<TextView>(R.id.drill_tips)
        val startButton = findViewById<Button>(R.id.start_ar_button)

        val drills = listOf("Drill 1", "Drill 2", "Drill 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, drills)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        desc.text = "Drill 1: Wall Mount Installation\n\nUse this drill to guide anchor placement for wall-mounted items like TVs or shelves."
                        tips.text = "Tip: Always measure height and use a spirit level before marking drill spots."
                    }
                    1 -> {
                        desc.text = "Drill 2: Ceiling Hook Setup\n\nDesigned for installing hanging lights or plants from the ceiling."
                        tips.text = "Tip: Ensure you’re drilling into a beam, not just plaster — use a stud finder."
                    }
                    2 -> {
                        desc.text = "Drill 3: Concrete Anchor Pilot\n\nHelps mark positions for heavy-duty concrete anchor bolts."
                        tips.text = "Tip: Use a hammer drill for better results and wear safety glasses."
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        startButton.setOnClickListener {
            val intent = Intent(this, HelloArActivity::class.java)
            startActivity(intent)
        }
    }
}
