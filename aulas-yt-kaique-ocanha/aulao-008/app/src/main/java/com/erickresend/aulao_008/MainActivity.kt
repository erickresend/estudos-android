package com.erickresend.aulao_008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erickresend.aulao_008.adapters.MainAdapter
import com.erickresend.aulao_008.databinding.ActivityMainBinding
import com.erickresend.aulao_008.repositories.MainRepository
import com.erickresend.aulao_008.rest.RetrofitService
import com.erickresend.aulao_008.viewmodel.main.MainViewModel
import com.erickresend.aulao_008.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    private val retofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retofitService))).get(
            MainViewModel::class.java
        )

        binding.recyclerview.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        viewModel.liveList.observe(this, Observer { lives ->
            Log.i("Kaique", "onStart")
            adapter.setLiveList(lives)
        })

        viewModel.erroMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllLives()
    }
}