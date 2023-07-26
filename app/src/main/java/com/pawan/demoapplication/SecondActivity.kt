package com.pawan.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pawan.demoapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackSecondActivity.setOnClickListener {
            onBackPressed()
        }
    }
}