package com.flb.fizzbuzz.views

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.flb.fizzbuzz.R

class MostFrequentFizzbuzzButton : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        inflate(context, R.layout.view_most_frequent_fizzbuzz_button, this)
    }
}