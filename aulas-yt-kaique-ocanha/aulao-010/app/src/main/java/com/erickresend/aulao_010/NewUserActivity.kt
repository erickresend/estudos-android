package com.erickresend.aulao_010

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickresend.aulao_010.database.AppDatabase
import com.erickresend.aulao_010.database.daos.UserDao
import com.erickresend.aulao_010.database.models.User
import com.erickresend.aulao_010.databinding.ActivityNewUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewUserBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)
        this.userDao = this.database.userDao()
    }

    override fun onStart() {
        super.onStart()

        binding.btnSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = saveUser(
                    binding.editFirstName.text.toString(),
                    binding.editLastName.text.toString()
                )
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@NewUserActivity,
                        if(result) "User saved!" else "Error trying  to save user",
                        Toast.LENGTH_LONG
                    ).show()
                    if(result) {
                        finish()
                    }
                }
            }
        }
    }

    private suspend fun saveUser(firstName: String, lastName: String): Boolean {
        if(firstName.isBlank() || firstName.isEmpty()) {
            return false
        }
        if(lastName.isBlank() || lastName.isEmpty()) {
            return false
        }
        userDao.insert(User(firstName, lastName))
        return true
    }
}