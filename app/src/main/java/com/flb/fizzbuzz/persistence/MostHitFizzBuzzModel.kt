package com.flb.fizzbuzz.persistence

import androidx.room.ColumnInfo

data class MostHitFizzBuzzModel(var fizzValue: Int = 0, var fizzText: String = "", var buzzValue: Int = 0, var buzzText: String = "", var limitValue: Int = 0, @ColumnInfo(name = "total") var hitsCount: Int = 0)