package tkm.at.minime

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ViewSwitcher
import tkm.at.minime.base.MMFragment
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * [Add class description here]
 *
 * Created 26.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
class CalendarFragment: MMFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        val compactCalendarView = view.findViewById(R.id.compactcalendar_view) as CompactCalendarView
        // Set first day of week to Monday, defaults to Monday so calling setFirstDayOfWeek is not necessary
        // Use constants provided by Java Calendar class
        compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY)

        // Add event 1 on Sun, 07 Jun 2015 18:20:51 GMT
        val ev1 = Event(Color.GREEN, System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1), "Some extra data that I want to store.")
        compactCalendarView.addEvent(ev1)

        // Added event 2 GMT: Sun, 07 Jun 2015 19:10:51 GMT
        val ev2 = Event(Color.RED, System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1))
        compactCalendarView.addEvent(ev2)

        val ev3 = Event(Color.RED, System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1))
        compactCalendarView.addEvent(ev1)

        val ev4 = Event(Color.BLACK, System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1))
        compactCalendarView.addEvent(ev2)

        compactCalendarView.setUseThreeLetterAbbreviation(true)
        compactCalendarView.shouldDrawIndicatorsBelowSelectedDays(true)


        // Query for events on Sun, 07 Jun 2015 GMT.
        // Time is not relevant when querying for events, since events are returned by day.
        // So you can pass in any arbitary DateTime and you will receive all events for that day.
        val events = compactCalendarView.getEvents(System.currentTimeMillis()) // can also take a Date object

        // events has size 2 with the 2 events inserted previously
        Log.d(TAG, "Events: " + events)

        // define a listener to receive callbacks when certain events happen.
        compactCalendarView.setListener(object : CompactCalendarView.CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date) {
                val events = compactCalendarView.getEvents(dateClicked)
                Log.d(TAG, "Day was clicked: $dateClicked with events $events")
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date) {
                Log.d(TAG, "Month was scrolled to: " + firstDayOfNewMonth)
            }
        })

        return view
    }

}