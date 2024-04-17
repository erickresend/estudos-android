package com.erickresend.retrofitexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostEntity>> = service.list()

        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onResponse(call: Call<List<PostEntity>>, response: Response<List<PostEntity>>) {
                Toast.makeText(applicationContext, "Ok", Toast.LENGTH_SHORT).show()
                val list = response.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}