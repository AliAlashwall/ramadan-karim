package com.example.ramadan_karim

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ramadan_karim.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
     private val baseFragment = OneFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseFile()
        initFragment()
        callBack()
    }
    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.oneFragment, baseFragment)
        transaction.commit()
    }
    private fun callBack() {

        binding.apply {
            n.setOnClickListener {
                bindDay(DataManager.getNextDay())
            }
            p.setOnClickListener {
                bindDay(DataManager.getPreviousDay())
            }
        }
    }
    private fun parseFile() {
        val inputStream = assets.open("Ramadan.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val current = parser.parse(it)
            DataManager.addDay(current)
        }
        bindDay(DataManager.getCurrentDay())
    }
    @SuppressLint("SetTextI18n")
    private fun bindDay(day: PrayerTime) {
        binding.apply {
            date.text = day.Date
            Fajr.text = "Fajr ${" ".repeat(50)} ${day.Fajr}"
            Duher.text = "Duher${" ".repeat(50)} ${day.Duher}"
            Asr.text = "Asr  ${" ".repeat(50)} ${day.Asr}"
            Maghrib.text = "Maghrib${" ".repeat(48)} ${day.Maghrib}"
            Isha.text = "Isha ${" ".repeat(50)} ${day.Isha}"
        }
    }

}

