package com.flb.fizzbuzz.createfizzbuzz

import java.io.Serializable

data class FormModel(val id: String, val resTitleId: Int, val hasWord: Boolean, val resIconId: Int, var word: String = "", var value: Int = 0) : Serializable