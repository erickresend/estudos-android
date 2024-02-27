package com.erickresend.secao24.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erickresend.secao24.infra.MotivationConstants
import com.erickresend.secao24.R
import com.erickresend.secao24.infra.SecurityPreferences
import com.erickresend.secao24.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener{
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            finish()
        } else {
            Toast.makeText(this, R.string.validation_madatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}