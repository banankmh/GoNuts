package com.banan.roomsession.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Provides
    @Singleton
    fun providesFirebaseDatabase(): FirebaseDatabase {
        return Firebase.database
    }

    @Provides
    @Singleton
    @Named("sessions")
    fun providesFirebaseSessionsData(
        firebaseDatabase: FirebaseDatabase
    ): DatabaseReference {
        return firebaseDatabase.reference.child(SESSIONS)
    }

    @Provides
    @Singleton
    @Named("visitors")
    fun providesFirebasePlayersData(
        firebaseDatabase: FirebaseDatabase
    ): DatabaseReference {
        return firebaseDatabase.reference.child(VISITORS)
    }

    companion object {
        const val SESSIONS = "sessions"
        const val VISITORS = "visitor"
    }
}