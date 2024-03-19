package com.erickresend.aulao_011.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickresend.aulao_011.R
import com.erickresend.aulao_011.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.btnSave.setOnClickListener {
            val replyIntnet = Intent()
            if(TextUtils.isEmpty(binding.editWord.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntnet)
            } else {
                val word = binding.editWord.text.toString()
                replyIntnet.putExtra("REPLY", word)
                setResult(Activity.RESULT_OK, replyIntnet)
            }
            finish()
        }
    }
}