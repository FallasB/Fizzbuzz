package com.flb.fizzbuzz.showfizzbuzz

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.flb.fizzbuzz.FizzbuzzApplication
import com.flb.fizzbuzz.FizzbuzzManager
import com.flb.fizzbuzz.databinding.ActivityShowFizzbuzzBinding
import com.flb.fizzbuzz.persistence.FizzbuzzViewModel
import com.flb.fizzbuzz.persistence.FizzbuzzViewModelFactory

class ShowFizzbuzzActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowFizzbuzzBinding
    private val fizzbuzzViewModel : FizzbuzzViewModel by viewModels {
        FizzbuzzViewModelFactory((application as FizzbuzzApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowFizzbuzzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = ShowFizzbuzzAdapter()

        fizzbuzzViewModel.insert(FizzbuzzManager.getFizzbuzz())
    }
}