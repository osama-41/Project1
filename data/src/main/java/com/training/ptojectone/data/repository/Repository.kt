package com.training.ptojectone.data.repository

import com.training.ptojectone.data.api.ProjectApi
import com.training.ptojectone.data.model.AchievementsResponseModel

class Repository(private val projectApi: ProjectApi){

//    suspend fun getAchievements(): List<AchievementsResponseModel> {
//        val achievementsApi = RetrofitBuilder.getInstance().create(ProjectApi::class.java)
//        return achievementsApi.getAchievements().data
//    }

    suspend fun getAchievements(): List<AchievementsResponseModel> {
        return projectApi.getAchievements().data
    }
}