package com.erickresend.aulao_07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erickresend.aulao_07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.buttomFirst.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_VALUE", binding.editTextFirst.text.toString())
            startActivity(intent)
        }

        binding.buttomGetSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_NAME", "name")
        }
    }


}