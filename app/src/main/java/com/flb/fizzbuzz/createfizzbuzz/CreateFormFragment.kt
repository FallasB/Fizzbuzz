package com.flb.fizzbuzz.createfizzbuzz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.flb.fizzbuzz.AnimationManager
import com.flb.fizzbuzz.databinding.FragmentCreateFormBinding

private const val ARG_PARAM = "formModel"

class CreateFormFragment : Fragment() {

    private var formModel: FormModel? = null

    private lateinit var binding: FragmentCreateFormBinding
    private val viewModel: FormCompletedViewModel by activityViewModels()

    private var isWordEmpty = true
    private var isValueEmpty = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            formModel = it.getSerializable(ARG_PARAM) as FormModel?
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateFormBinding.inflate(layoutInflater)
        populateView()
        return binding.root
    }

    private fun populateView() {
        formModel?.let {safeFormModel ->

            binding.formTitle.text = getString(safeFormModel.resTitleId)
            if (!safeFormModel.hasWord) {
                binding.inputLayoutWord.visibility = View.GONE
            }
            binding.nextButton.setImageResource(safeFormModel.resIconId)

            binding.nextButton.setOnClickListener {
                safeFormModel.value = Integer.valueOf(binding.editTextValue.text.toString())
                if (safeFormModel.hasWord) {
                    safeFormModel.word = binding.editTextWord.text.toString()
                }

                viewModel.formComplete(safeFormModel)
            }

            binding.editTextWord.doOnTextChanged { text, _, _, _ ->
                text?.let {
                    if (it.isNotEmpty() && isWordEmpty && !isValueEmpty) {
                        setNextButtonEnabled(true)
                    } else if (it.isEmpty()) {
                        setNextButtonEnabled(false)
                    }
                    isWordEmpty = it.isEmpty()
                }
            }

            binding.editTextValue.doOnTextChanged { text, _, _, _ ->
                text?.let {
                    if (it.isNotEmpty() && isValueEmpty && (!isWordEmpty || binding.inputLayoutWord.visibility != View.VISIBLE)) {
                        setNextButtonEnabled(true)
                    } else if (it.isEmpty()) {
                        setNextButtonEnabled(false)
                    }
                    isValueEmpty = it.isEmpty()
                }
            }
        }
    }

    private fun setNextButtonEnabled(shouldEnable: Boolean) {
        binding.nextButton.isEnabled = shouldEnable
        val alphaValue = if (shouldEnable) 1f else 0.2f
        AnimationManager.animateToAlpha(binding.nextButton, alphaValue)
    }

    companion object {
        @JvmStatic
        fun newInstance(formModel: FormModel) =
            CreateFormFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, formModel)
                }
            }
    }
}