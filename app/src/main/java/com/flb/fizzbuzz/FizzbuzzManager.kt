package com.flb.fizzbuzz

import com.flb.fizzbuzz.persistence.FizzBuzzModel

class FizzbuzzManager {
    companion object {
        private var fizzbuzz = FizzBuzzModel()

        fun setFizz(word: String, value: Int) {
            fizzbuzz.fizzText = word
            fizzbuzz.fizzValue = value
        }

        fun setBuzz(word: String, value: Int) {
            fizzbuzz.buzzText = word
            fizzbuzz.buzzValue = value
        }

        fun setLimit(value: Int) {
            fizzbuzz.limitValue = value
        }

        fun getFizzbuzz() : FizzBuzzModel {
            return fizzbuzz
        }

        fun getComputedValue(value: Int): String {
            return when {
                isFizzbuzz(value) -> {
                    fizzbuzz.fizzText + fizzbuzz.buzzText
                }
                isFizz(value) -> {
                    fizzbuzz.fizzText
                }
                isBuzz(value) -> {
                    fizzbuzz.buzzText
                }
                else -> {
                    value.toString()
                }
            }
        }

        private fun isFizz(value: Int): Boolean {
            return value % fizzbuzz.fizzValue == 0
        }

        private fun isBuzz(value: Int): Boolean {
            return value % fizzbuzz.buzzValue == 0
        }

        private fun isFizzbuzz(value: Int): Boolean {
            return isFizz(value) && isBuzz(value)
        }
    }
}