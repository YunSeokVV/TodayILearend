package com.example.fooddex.di

import com.example.fooddex.repository.MainActivityRepository
import com.example.fooddex.repository.MainActivityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsMainRepository(mainRepositoryImpl: MainActivityRepositoryImpl): MainActivityRepository
}