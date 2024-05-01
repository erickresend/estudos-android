package com.erickresend.aplicativoteste.view.telaprincipal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erickresend.aplicativoteste.databinding.ActivityTelaPrincipalBinding
import com.erickresend.aplicativoteste.view.formlogin.FormLoginActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this, FormLoginActivity::class.java)
            startActivity(voltarTelaLogin)
            finish()
        }

        binding.btnGravarDadosDB.setOnClickListener { view ->

            val usuariosMap = hashMapOf(
                "nome" to "Erick",
                "sobrenome" to "Resende",
                "idade" to 30
            )

            db.collection("Usuários").document("Erick")
                .set(usuariosMap).addOnCompleteListener {
                    val snackbar = Snackbar.make(view, "Sucesso ao salvar dados os do usuário", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.BLUE)
                    snackbar.show()
                }.addOnFailureListener {

                }
        }

        binding.btnLerDadosDB.setOnClickListener {
            db.collection("Usuários").document("Erick")
                .addSnapshotListener { value, error ->
                if(value != null) {
                    binding.textResultadoNome.text = value.getString("nome")
                    binding.textResultadoSobrenome.text = value.getString("sobrenome")
                    binding.textResultadoIdade.text = value.getLong("idade").toString()
                }
            }
        }

        binding.btnAtualizarDadosDB.setOnClickListener { view ->
            db.collection("Usuários").document("Erick")
                .update("sobrenome", "Amaral Resende", "idade", 31).addOnCompleteListener {
                    val snackbar = Snackbar.make(view, "Sucesso ao atualizar os dados do usuário", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.BLUE)
                    snackbar.show()
                }
        }

        binding.btnDeletarDadosDB.setOnClickListener {view ->
            db.collection("Usuários").document("Erick")
                .delete().addOnCompleteListener {
                    val snackbar = Snackbar.make(view, "Sucesso ao deletar usuário", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.BLUE)
                    snackbar.show()
                }
        }
    }
}