package com.flb.fizzbuzz.mostfrequent

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.flb.fizzbuzz.FizzbuzzApplication
import com.flb.fizzbuzz.databinding.ActivityMostFrequentFizzbuzzBinding
import com.flb.fizzbuzz.persistence.FizzbuzzViewModel
import com.flb.fizzbuzz.persistence.FizzbuzzViewModelFactory

class MostFrequentFizzbuzzActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostFrequentFizzbuzzBinding
    private val fizzbuzzViewModel : FizzbuzzViewModel by viewModels {
        FizzbuzzViewModelFactory((application as FizzbuzzApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMostFrequentFizzbuzzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exitIcon.setOnClickListener {
            finish()
        }

        fizzbuzzViewModel.mostUsedFizzbuss.observe(this) { fizzbuzz ->
            binding.fizzbuzzStatisticView.populate(fizzbuzz)
        }
    }
}