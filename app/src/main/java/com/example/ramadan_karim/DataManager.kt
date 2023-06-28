package com.example.ramadan_karim

import android.widget.Toast

object DataManager {
    private val dayList = mutableListOf<PrayerTime>()
    var dayIndex = 0

    fun addDay(day : PrayerTime){
        dayList.add(day)
    }
    fun getCurrentDay():PrayerTime = dayList[dayIndex]

    fun getNextDay(): PrayerTime {
        if (dayIndex < 30 ){dayIndex++}
        return dayList[dayIndex]
    }

    fun getPreviousDay(): PrayerTime {
        if (dayIndex > 0 ){dayIndex--}
        return dayList[dayIndex]
    }
}