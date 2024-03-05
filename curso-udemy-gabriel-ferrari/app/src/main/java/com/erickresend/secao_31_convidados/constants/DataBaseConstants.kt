package com.erickresend.secao_31_convidados.constants

// Criado para ter as constantes para não correr o risco de errar na hora de usar os nomes da tabela e colunas
class DataBaseConstants private constructor() {

    object Guest {
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}