package com.training.ptojectone.data.api

import com.training.ptojectone.data.model.AchievementsResponseModel
import com.training.ptojectone.data.model.WrappedAchievementsResponseModel
import retrofit2.http.GET

interface ProjectApi {

    @GET("/achievements")
    suspend fun getAchievements(): WrappedAchievementsResponseModel
}