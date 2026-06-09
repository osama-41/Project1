package com.training.ptojectone.data.di

import com.training.ptojectone.data.api.ProjectApi
import com.training.ptojectone.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(projectApi: ProjectApi): Repository{
        return Repository(projectApi)
    }
}