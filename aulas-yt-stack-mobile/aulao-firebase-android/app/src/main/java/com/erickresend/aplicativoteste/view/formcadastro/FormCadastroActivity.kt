package com.erickresend.aplicativoteste.view.formcadastro

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erickresend.aplicativoteste.databinding.ActivityFormCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener { it ->

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(it, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
                    if(cadastro.isSuccessful) {
                        val snackbar = Snackbar.make(it, "Sucesso ao cadastrar usuário!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        binding.editEmail.setText("")
                        binding.editSenha.setText("")
                    }
                }.addOnFailureListener { exception ->

                    val mensagemErro = when(exception) {
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                        is FirebaseAuthUserCollisionException -> "Esta conta já foi cadastrada!"
                        is FirebaseNetworkException -> "Sem conexão com a internet!"
                        else -> "Erro ao cadastrar usuário!"
                    }
                    val snackbar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }
}