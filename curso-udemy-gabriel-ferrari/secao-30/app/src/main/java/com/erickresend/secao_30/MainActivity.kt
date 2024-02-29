package com.erickresend.secao_30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.erickresend.secao_30.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObserver()

    }

    fun setObserver() {
        viewModel.welcome().observe(this, {
            binding.textWelcome.text = it
        })

        viewModel.login().observe(this, {
            if(it) {
                Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "FALHA!", Toast.LENGTH_LONG).show()
            }
        })
    }
}