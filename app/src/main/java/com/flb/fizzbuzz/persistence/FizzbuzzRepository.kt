package com.flb.fizzbuzz.persistence

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class FizzbuzzRepository(private val fizzbuzzDao: FizzbuzzDao) {

    val mostUsedFizzbuss : Flow<MostHitFizzBuzzModel> = fizzbuzzDao.getMostUsedFizzbuzz()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(fizzBuzzModel: FizzBuzzModel) {
        fizzbuzzDao.insert(fizzBuzzModel)
    }
}

