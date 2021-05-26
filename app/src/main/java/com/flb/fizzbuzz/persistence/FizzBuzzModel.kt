package com.flb.fizzbuzz.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fizzbuzz_table")
data class FizzBuzzModel(@PrimaryKey(autoGenerate = true) val id : Int = 0, var fizzValue: Int = 0, var fizzText: String = "", var buzzValue: Int = 0, var buzzText: String = "", var limitValue: Int = 0)