package com.example.android1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android1.databinding.ActivityMainBinding

class userActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}