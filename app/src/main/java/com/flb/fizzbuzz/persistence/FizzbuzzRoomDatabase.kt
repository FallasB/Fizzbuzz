package com.flb.fizzbuzz.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(FizzBuzzModel::class), version = 1, exportSchema = false)
public abstract class FizzbuzzRoomDatabase : RoomDatabase() {

    abstract fun fizzbuzzDao(): FizzbuzzDao

    companion object {
        @Volatile
        private var INSTANCE: FizzbuzzRoomDatabase? = null

        fun getDatabase(context: Context): FizzbuzzRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FizzbuzzRoomDatabase::class.java,
                    "fizzbuzz_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}