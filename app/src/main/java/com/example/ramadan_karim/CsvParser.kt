package com.example.ramadan_karim

class CsvParser {
    fun parse(line :String) :PrayerTime{
        val token = line.split(",")
        return PrayerTime(
            Date = token[0],
            Fajr = token[1],
            Dhuhr = token[3],
            Asr = token[4],
            Maghrib =  token[5],
            Isha = token[6]
        )
    }
}