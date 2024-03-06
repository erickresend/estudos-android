package com.erickresend.aulao_006

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.erickresend.aulao_006.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 48:09

    private lateinit var binding: ActivityMainBinding
    private lateinit var liveAdapter: LiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource() {
        val dataSource = DataSource.createDataSet()
        this.liveAdapter.setDataSet(dataSource)
    }


    private fun initRecyclerView() {

        this.liveAdapter = LiveAdapter { live ->
            opneLink(live.link)
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerview.adapter = liveAdapter

        //recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        //recyclerview.adapter = this.liveAdapter
    }

    private fun opneLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}