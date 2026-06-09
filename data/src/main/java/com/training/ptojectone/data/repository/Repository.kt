package com.training.ptojectone.data.repository

import com.training.ptojectone.data.api.ProjectApi
import com.training.ptojectone.data.model.AchievementsResponseModel
import com.training.ptojectone.data.network.RetrofitBuilder

class Repository {

    suspend fun getAchievements(): List<AchievementsResponseModel> {
        val achievementsApi = RetrofitBuilder.getInstance().create(ProjectApi::class.java)
        return achievementsApi.getAchievements().data
    }
}