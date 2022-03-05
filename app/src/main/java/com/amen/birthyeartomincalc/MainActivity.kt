package com.amen.birthyeartomincalc

import android.icu.text.SimpleDateFormat
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var txtSelectedDate : TextView? = null
    private var txtDateInMin : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtDateInMin = findViewById(R.id.DateInMIn)
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
        val datePickerDialog = DatePickerDialog(
            this,
            { _, chosenYear, chosenMonth, chosenDayOfMonth ->
                val selectedDate = "$chosenDayOfMonth.${chosenMonth + 1}.$chosenYear"
                txtSelectedDate?.text = selectedDate

                val dataFormat = java.text.SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)

                val reqDate = dataFormat.parse(selectedDate)

                reqDate?.let {
                    val reqDateInMin = reqDate.time/60000

                    val currentDate = dataFormat.parse((dataFormat.format(System.currentTimeMillis())))

                    currentDate?.let {
                        val currentDateInMin = currentDate.time/60000

                        val diffInMin = currentDateInMin - reqDateInMin

                        txtDateInMin?.text = diffInMin.toString()
                    }

                }
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis() - 86400000
        datePickerDialog.show()
    }
}