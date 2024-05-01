package com.erickresend.aplicativoteste.view.formlogin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erickresend.aplicativoteste.R
import com.erickresend.aplicativoteste.databinding.ActivityFormCadastroBinding
import com.erickresend.aplicativoteste.databinding.ActivityFormLoginBinding
import com.erickresend.aplicativoteste.view.formcadastro.FormCadastroActivity
import com.erickresend.aplicativoteste.view.telaprincipal.TelaPrincipalActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener { view ->

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
                    if(autenticacao.isSuccessful) {
                        navegarTelaPrincipal()
                    }
                }.addOnFailureListener {
                    val snackbar = Snackbar.make(view, "Erro ao fazer login do usuário!", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }

        binding.textTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = auth.currentUser

        if(usuarioAtual != null) {
            navegarTelaPrincipal()
        }
    }

    private fun navegarTelaPrincipal() {
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }
}