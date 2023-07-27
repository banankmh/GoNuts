package com.banan.roomsession.di

import com.banan.roomsession.repo.RoomRepo
import com.banan.roomsession.repo.RoomRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindGameRepository(
        gameRepositoryImp: RoomRepoImpl
    ): RoomRepo
}