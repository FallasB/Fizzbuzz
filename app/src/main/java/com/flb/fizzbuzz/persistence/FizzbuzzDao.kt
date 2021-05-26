package com.flb.fizzbuzz.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FizzbuzzDao {
    @Query("SELECT * FROM (SELECT fizzValue, fizzText, buzzText, buzzValue, limitValue, COUNT(*) as total FROM fizzbuzz_table GROUP BY fizzValue, fizzText, buzzText, buzzValue, limitValue) AS mergedFizzbuzz ORDER BY total DESC LIMIT 1")
    fun getMostUsedFizzbuzz(): Flow<MostHitFizzBuzzModel>

    @Insert
    suspend fun insert(fizzbuzz: FizzBuzzModel)
}