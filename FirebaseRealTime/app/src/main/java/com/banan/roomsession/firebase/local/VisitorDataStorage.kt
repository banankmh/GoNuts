package com.banan.roomsession.firebase.local

interface VisitorDataStorage {

    suspend fun getVisitorById(): String?

    suspend fun saveVisitorId(visitorId: String)

    suspend fun clearVisitorId()
}