package com.flb.fizzbuzz.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.flb.fizzbuzz.databinding.ViewMostFrequentFizzbuzzStatisticBinding
import com.flb.fizzbuzz.persistence.MostHitFizzBuzzModel

class MostFrequentFizzbuzzStatisticView : CardView {

    private var binding: ViewMostFrequentFizzbuzzStatisticBinding =
        ViewMostFrequentFizzbuzzStatisticBinding.inflate(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater, this)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    fun populate(fizzbuzz: MostHitFizzBuzzModel) {
        binding.fizzWordContent.text = fizzbuzz.fizzText
        binding.fizzValueContent.text = fizzbuzz.fizzValue.toString()
        binding.buzzWordContent.text = fizzbuzz.buzzText
        binding.buzzValueContent.text = fizzbuzz.buzzValue.toString()
        binding.limitValueContent.text = fizzbuzz.limitValue.toString()
        binding.hitsValueContent.text = fizzbuzz.hitsCount.toString()
    }
}