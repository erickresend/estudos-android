package com.erickresend.aulao_011

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.aulao_011.application.WordsApplication
import com.erickresend.aulao_011.database.models.Word
import com.erickresend.aulao_011.databinding.ActivityMainBinding
import com.erickresend.aulao_011.ui.adapters.WordListAdapter
import com.erickresend.aulao_011.ui.view.NewWordActivity
import com.erickresend.aulao_011.ui.viewmodels.WordViewModel
import com.erickresend.aulao_011.ui.viewmodels.WordViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: WordListAdapter
    private lateinit var binding: ActivityMainBinding

    private val wordViewModel : WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerview = binding.recyclerview
        adapter = WordListAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                result.data?.let{
                    it.getStringExtra("REPLY")?.let { it1 -> Word(it1) }?.let { it2 ->
                        wordViewModel.insert(
                            it2
                        )
                    }
                }
            }
        }
        binding.fab.setOnClickListener {
            resultLauncher.launch(Intent(this, NewWordActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        wordViewModel.allWords.observe(this, Observer { words ->
            words?.let { adapter.submitList(it) }
        })
    }
}