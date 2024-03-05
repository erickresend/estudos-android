package com.erickresend.secao_31_convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.erickresend.secao_31_convidados.constants.DataBaseConstants


// Essa classe seria a classe de conexao com o banco
class GuestDataBase(
    context: Context
) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${DataBaseConstants.Guest.TABLE_NAME} " +
                "(${DataBaseConstants.Guest.COLUMNS.ID} interger primary key autoincrement, " +
                "${DataBaseConstants.Guest.COLUMNS.NAME} text, " +
                "${DataBaseConstants.Guest.COLUMNS.PRESENCE} integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}