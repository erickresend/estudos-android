package com.erickresend.secao24.ui

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.erickresend.secao24.data.Mock
import com.erickresend.secao24.infra.MotivationConstants
import com.erickresend.secao24.infra.SecurityPreferences
import com.erickresend.secao24.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleNextPhrase()

        binding.imageAll.setOnClickListener {
            binding.imageAll.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            categoryId = MotivationConstants.FILTER.ALL
        }
        binding.imageHappy.setOnClickListener {
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            binding.imageAll.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            categoryId = MotivationConstants.FILTER.HAPPY
        }
        binding.imageSunny.setOnClickListener {
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            binding.imageAll.setColorFilter(ContextCompat.getColor(this, android.R.color.black))
            categoryId = MotivationConstants.FILTER.SUNNY
        }
        binding.buttonNewPhrase.setOnClickListener {
            handleNextPhrase()
        }
        binding.textUserName.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    private fun handleUserName() {
        binding.textUserName.text =
            "Olá ${SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)}"
    }

    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPharse(categoryId, Locale.getDefault().language)
    }
}