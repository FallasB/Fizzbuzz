package com.flb.fizzbuzz

import android.app.Application
import com.flb.fizzbuzz.persistence.FizzbuzzRepository
import com.flb.fizzbuzz.persistence.FizzbuzzRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FizzbuzzApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { FizzbuzzRoomDatabase.getDatabase(this) }
    val repository by lazy { FizzbuzzRepository(database.fizzbuzzDao()) }
}