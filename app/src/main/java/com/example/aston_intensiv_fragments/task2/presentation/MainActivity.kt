package com.example.aston_intensiv_fragments.task2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.container, StartFragment())
            .commit()
    }
}