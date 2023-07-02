package com.example.ramadan_karim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ramadan_karim.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)

        callback()
        return binding.root
    }

private fun callback(){
    val myButton = binding.startButton

    myButton.setOnClickListener {
        myButton.visibility = GONE
        parentFragmentManager.beginTransaction().remove(this).commit()
    }
}

}