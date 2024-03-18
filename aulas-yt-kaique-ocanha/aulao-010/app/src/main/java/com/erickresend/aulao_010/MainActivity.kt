package com.erickresend.aulao_010

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erickresend.aulao_010.database.AppDatabase
import com.erickresend.aulao_010.database.daos.UserDao
import com.erickresend.aulao_010.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.database = AppDatabase.getInstance(this)
        this.userDao = this.database.userDao()

    }

    override fun onStart() {
        super.onStart()

        loadTotalUsers()

        binding.btnNewUser.setOnClickListener {
            openNewUserActivity()
        }
    }

    private fun openNewUserActivity() {
        startActivity(Intent(this, NewUserActivity::class.java))
    }

    private fun loadTotalUsers() {
        binding.textTotalUsers.text = "Carregando..."
        CoroutineScope(Dispatchers.IO).launch {
            val total = userDao.getTotalItems().toString()

            withContext(Dispatchers.Main) {
                binding.textTotalUsers.text = "Total de usuários: $total"
            }
        }
    }
}