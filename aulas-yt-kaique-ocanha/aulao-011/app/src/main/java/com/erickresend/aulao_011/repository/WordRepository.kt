package com.erickresend.aulao_011.repository

import androidx.annotation.WorkerThread
import com.erickresend.aulao_011.database.daos.WordDao
import com.erickresend.aulao_011.database.models.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}