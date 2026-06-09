package com.training.ptojectone.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.ptojectone.data.model.AchievementsResponseModel
import com.training.ptojectone.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _achievementsSuccessLiveData: MutableLiveData<List<AchievementsResponseModel>> = MutableLiveData()
    val achievementsSuccessLiveData: LiveData<List<AchievementsResponseModel>> = _achievementsSuccessLiveData

    private val _achievementsErrorLiveData: MutableLiveData<Exception> = MutableLiveData()
    val achievementsErrorLiveData: LiveData<Exception> = _achievementsErrorLiveData

    private val _achievementsLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val achievementsLoadingLiveData: LiveData<Boolean> = _achievementsLoadingLiveData

    init {
        getAchievements()
    }

    fun getAchievements() {
        viewModelScope.launch {
            _achievementsLoadingLiveData.postValue(true)
            try {
                val response = repository.getAchievements()
                _achievementsSuccessLiveData.postValue(response)
            } catch (e: Exception) {
                _achievementsErrorLiveData.postValue(e)
            }
            _achievementsLoadingLiveData.postValue(false)
        }
    }
}