package com.flb.fizzbuzz.createfizzbuzz

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.flb.fizzbuzz.FizzbuzzManager
import com.flb.fizzbuzz.R
import com.flb.fizzbuzz.databinding.ActivityCreateFizzBuzzBinding
import com.flb.fizzbuzz.showfizzbuzz.ShowFizzbuzzActivity

class CreateFizzBuzzActivity : AppCompatActivity() {

    companion object {
        val fizzFormModel = FormModel("FIZZ", R.string.create_form_fizz_title, true, R.drawable.ic_navigate_next)
        val buzzFormModel = FormModel("BUZZ", R.string.create_form_buzz_title, true, R.drawable.ic_navigate_next)
        val limitFormModel = FormModel("LIMIT", R.string.create_form_limit_title, false, R.drawable.ic_done)
    }

    private lateinit var binding: ActivityCreateFizzBuzzBinding
    private val viewModel: FormCompletedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateFizzBuzzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val fragment = CreateFormFragment.newInstance(fizzFormModel)
                add(R.id.fragment_container_view, fragment)
            }
        }

        viewModel.formCompleted.observe(this, Observer { model ->
            when (model.id) {
                fizzFormModel.id -> {
                    FizzbuzzManager.setFizz(model.word, model.value)
                    setFragment(buzzFormModel)
                }
                buzzFormModel.id -> {
                    FizzbuzzManager.setBuzz(model.word, model.value)
                    setFragment(limitFormModel)
                }
                else -> {
                    FizzbuzzManager.setLimit(model.value)
                    val intent = Intent(this, ShowFizzbuzzActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        })

        binding.exitIcon.setOnClickListener {
            finish()
        }
    }

    private fun setFragment(formModel: FormModel) {
        supportFragmentManager.commit {
            setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            val fragment = CreateFormFragment.newInstance(formModel)
            replace(R.id.fragment_container_view, fragment)
        }
    }
}