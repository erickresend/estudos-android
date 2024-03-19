package com.erickresend.aulao_011.application

import android.app.Application
import com.erickresend.aulao_011.database.WordRoomDatabase
import com.erickresend.aulao_011.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication: Application() {

    //No manifest tem que colocar na parte de application
    //android:name=".application.WordsApplication"
    //Serve para ter apenas uma instancia dessas variaveis

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(applicationScope,this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}