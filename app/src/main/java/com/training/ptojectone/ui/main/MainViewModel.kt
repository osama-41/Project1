package com.training.ptojectone.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.ptojectone.data.model.AchievementsResponseModel
import com.training.ptojectone.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    val achievementsSuccessLiveData: MutableLiveData<List<AchievementsResponseModel>> = MutableLiveData()
    val achievementsErrorLiveData: MutableLiveData<Exception> = MutableLiveData()

    init {
        getAchievements()
    }

    fun getAchievements() {
        viewModelScope.launch {
            try {
                val response = repository.getAchievements()
                achievementsSuccessLiveData.postValue(response)
            } catch (e: Exception) {
                achievementsErrorLiveData.postValue(e)
            }
        }
    }
}