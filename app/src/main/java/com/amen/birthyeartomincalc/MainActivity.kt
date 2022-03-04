package com.amen.birthyeartomincalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private var txtSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalendarPop : Button = findViewById(R.id.CalendarPop)
        txtSelectedDate = findViewById(R.id.SelectedDate)
        btnCalendarPop.setOnClickListener {
            clickCalendarPop()
        }
    }

    private fun clickCalendarPop(){


        val calendarPop = Calendar.getInstance()
        val year = calendarPop.get(Calendar.YEAR)
        val month = calendarPop.get(Calendar.MONTH)
        val day = calendarPop.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, chosenYear, chosenMonth, chosenDayOfMonth ->
                val selectedDate = "$chosenDayOfMonth.$chosenMonth.$chosenYear"
                txtSelectedDate?.text = selectedDate
            },
            year,
            month,
            day
        ).show()




    }
}