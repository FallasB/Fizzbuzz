package com.flb.fizzbuzz.persistence

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class FizzbuzzViewModel(private val repository: FizzbuzzRepository) : ViewModel() {
    val mostUsedFizzbuss: LiveData<MostHitFizzBuzzModel> = repository.mostUsedFizzbuss.asLiveData()

    fun insert(fizzBuzzModel: FizzBuzzModel) = viewModelScope.launch {
        repository.insert(fizzBuzzModel)
    }
}

class FizzbuzzViewModelFactory(private val repository: FizzbuzzRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FizzbuzzViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FizzbuzzViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}