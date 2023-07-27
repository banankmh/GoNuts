package com.banan.roomsession.di

import com.banan.roomsession.firebase.SessionImpl
import com.banan.roomsession.firebase.VisitorImpl
import com.banan.roomsession.firebase.local.VisitorDataStorage
import com.banan.roomsession.firebase.local.VisitorDataStorageImpl
import com.banan.roomsession.firebase.remote.SessionDataBase
import com.banan.roomsession.firebase.remote.VisitorDataBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindVisitorDataStorage(
        visitorDataStorageImp: VisitorDataStorageImpl
    ): VisitorDataStorage

    @Binds
    abstract fun bindFirebaseVisitorDatabase(
        firebasePlayerDatabaseImp: VisitorImpl
    ): VisitorDataBase

    @Binds
    abstract fun bindFirebaseSessionDatabase(
        firebaseSessionDatabaseImp: SessionImpl
    ): SessionDataBase
}