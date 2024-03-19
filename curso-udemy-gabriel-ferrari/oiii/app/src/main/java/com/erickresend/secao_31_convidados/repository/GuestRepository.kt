package com.erickresend.secao_31_convidados.repository

import android.content.ContentValues
import android.content.Context
import com.erickresend.secao_31_convidados.constants.DataBaseConstants
import com.erickresend.secao_31_convidados.model.GuestModel

// é colocado o construtor privado para não conseguir instanciar a classe
class GuestRepository private constructor(contect: Context) {

    private val guestDataBase = GuestDataBase(contect)

    // Padrao singleton
    companion object {
        private lateinit var repository: GuestRepository

        // verificando de já tem um repositorio inicializado
        fun getInstance(context: Context): GuestRepository {
            if(!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel): Boolean {
        return try {
            //Existe writableDatabase e readableDatabase um pode inserir e atulizar o outro só ler
            val db = guestDataBase.writableDatabase
            //SQLite nao salva booleano, então tem que fazer essa verificação
            val presence = if(guest.presence) 1 else 0

            //Colocando o conteudo que sera inserido em uma variavel pra usar como argumento no insert
            val values = ContentValues()
            values.put(DataBaseConstants.Guest.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.Guest.COLUMNS.PRESENCE, presence)

            db.insert(DataBaseConstants.Guest.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update() {

    }
}