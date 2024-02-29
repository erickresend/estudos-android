package com.erickresend.aulao_07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erickresend.aulao_07.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.textSecond.text = intent.getStringExtra("TEXT_VALUE")
    }

    override fun onResume() {
        super.onResume()
        binding.buttomSecond.setOnClickListener {
            val data = Intent()
            data.putExtra("RETURN", binding.textSecond.text.toString())
            setResult(RESULT_OK, data)
            finish()
        }
    }
}