package com.flb.fizzbuzz.createfizzbuzz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormCompletedViewModel : ViewModel() {
    private val mutableFormCompleted = MutableLiveData<FormModel>()
    val formCompleted: LiveData<FormModel> get() = mutableFormCompleted

    fun formComplete(form: FormModel) {
        mutableFormCompleted.value = form
    }
}