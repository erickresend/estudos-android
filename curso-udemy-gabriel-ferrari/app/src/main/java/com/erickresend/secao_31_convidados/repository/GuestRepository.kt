package com.erickresend.secao_31_convidados.repository

import android.content.ContentValues
import android.content.Context
import com.erickresend.secao_31_convidados.constants.DataBaseConstants
import com.erickresend.secao_31_convidados.model.GuestModel

// é colocado o construtor privado para não conseguir instanciar a classe
class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase(context)

    // Padrao singleton
    companion object {
        private lateinit var repository: GuestRepository

        // verificando de já tem um repositorio inicializado
        fun getInstance(context: Context): GuestRepository {
            if(!::repository.isInitialized) {
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

    fun update(guest: GuestModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (guest.presence) 1 else 0
            //Segundo argumento são os valores que serao atualizados
            val values = ContentValues()
            values.put(DataBaseConstants.Guest.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.Guest.COLUMNS.PRESENCE, presence)
            //Terceiro argumento é o where
            val selection = DataBaseConstants.Guest.COLUMNS.ID + " = ?"
            //Quarto argumento é o valor do where
            val args = arrayOf(guest.id.toString())
            db.update(DataBaseConstants.Guest.TABLE_NAME, values, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            //segundo argumento é o where
            val selection = DataBaseConstants.Guest.COLUMNS.ID + " = ?"
            //terceiro argumento é o valor do where
            val args = arrayOf(id.toString())
            db.delete(DataBaseConstants.Guest.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAll(): List<GuestModel> {

        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = guestDataBase.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.Guest.COLUMNS.ID,
                DataBaseConstants.Guest.COLUMNS.NAME,
                DataBaseConstants.Guest.COLUMNS.PRESENCE
            )
            val cursor = db.query(
                DataBaseConstants.Guest.TABLE_NAME, projection,
                null, null,
                null, null, null
            )

            if(cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex((DataBaseConstants.Guest.COLUMNS.ID)))
                    val name = cursor.getString(cursor.getColumnIndex((DataBaseConstants.Guest.COLUMNS.NAME)))
                    val presence = cursor.getInt(cursor.getColumnIndex((DataBaseConstants.Guest.COLUMNS.PRESENCE)))

                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            cursor.close()
            list
        } catch (e: Exception) {
            list
        }
    }

    fun getPresent(): List<GuestModel> {

        val list= mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.Guest.COLUMNS.ID,
                DataBaseConstants.Guest.COLUMNS.NAME,
                DataBaseConstants.Guest.COLUMNS.PRESENCE
            )
            val selection = DataBaseConstants.Guest.COLUMNS.PRESENCE + " = ?"
            val args = arrayOf("1")
            val cursor = db.query(
                DataBaseConstants.Guest.TABLE_NAME, projection,
                selection, args,
                null, null, null
            )

            if(cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.ID)))
                    val name = cursor.getString(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.NAME)))
                    val presence = cursor.getInt(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.PRESENCE)))

                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }

    fun getAbsent(): List<GuestModel> {

        val list= mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.Guest.COLUMNS.ID,
                DataBaseConstants.Guest.COLUMNS.NAME,
                DataBaseConstants.Guest.COLUMNS.PRESENCE
            )
            val selection = DataBaseConstants.Guest.COLUMNS.PRESENCE + " = ?"
            val args = arrayOf("0")
            val cursor = db.query(
                DataBaseConstants.Guest.TABLE_NAME, projection,
                selection, args,
                null, null, null
            )

            if(cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.ID)))
                    val name = cursor.getString(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.NAME)))
                    val presence = cursor.getInt(cursor.getColumnIndexOrThrow((DataBaseConstants.Guest.COLUMNS.PRESENCE)))

                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }
}