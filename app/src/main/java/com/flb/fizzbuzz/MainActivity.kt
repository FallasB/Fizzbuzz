package com.flb.fizzbuzz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.flb.fizzbuzz.createfizzbuzz.CreateFizzBuzzActivity
import com.flb.fizzbuzz.databinding.ActivityMainBinding
import com.flb.fizzbuzz.mostfrequent.MostFrequentFizzbuzzActivity
import com.flb.fizzbuzz.persistence.FizzbuzzViewModel
import com.flb.fizzbuzz.persistence.FizzbuzzViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fizzbuzzViewModel : FizzbuzzViewModel by viewModels {
        FizzbuzzViewModelFactory((application as FizzbuzzApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLayout.setOnClickListener {
            slideInActivity(Intent(this, CreateFizzBuzzActivity::class.java))
        }

        AnimationManager.scaleReverseForEver(binding.buttonLayout)

        fizzbuzzViewModel.mostUsedFizzbuss.observe(this) { fizzbuzz ->
            binding.mostFrequentButton.visibility = if (fizzbuzz != null) View.VISIBLE else View.GONE
        }

        binding.mostFrequentButton.setOnClickListener {
            slideInActivity(Intent(this, MostFrequentFizzbuzzActivity::class.java))
        }
    }

    private fun slideInActivity(intent: Intent) {
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_up, 0)
    }
}