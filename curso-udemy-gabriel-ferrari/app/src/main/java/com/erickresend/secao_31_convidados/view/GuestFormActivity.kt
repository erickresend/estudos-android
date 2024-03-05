package com.erickresend.secao_31_convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.erickresend.secao_31_convidados.model.GuestModel
import com.erickresend.secao_31_convidados.databinding.ActivityGuestFormBinding
import com.erickresend.secao_31_convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.radioPresent.isChecked = true
        binding.buttonSave.setOnClickListener {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            //Mandar os dados para a view model para de la mandar para o repositorio
            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}