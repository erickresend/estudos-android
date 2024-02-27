package com.erickresend.secao24.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.erickresend.secao24.data.Mock
import com.erickresend.secao24.infra.MotivationConstants
import com.erickresend.secao24.infra.SecurityPreferences
import com.erickresend.secao24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        handleNextPhrase()

        binding.buttonNewPhrase.setOnClickListener {
            Toast.makeText(this, "Deu certo", Toast.LENGTH_SHORT).show()
        }
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
    }

    private fun handleUserName() {
        binding.textUserName.text =
                //Foi criado a classe motivationConstants apenas para não passar a string direta e ter menos chance de erro
            "Olá ${SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)}"
    }

    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPharse(categoryId)
    }
}