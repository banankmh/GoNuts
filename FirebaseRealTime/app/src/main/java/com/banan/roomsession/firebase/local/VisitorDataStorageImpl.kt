package com.banan.roomsession.firebase.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class VisitorDataStorageImpl@Inject constructor(
    private val dataStore: DataStore<Preferences>
) : VisitorDataStorage{
    override suspend fun getVisitorById(): String? {
        val preferences = dataStore.data.first()
        return preferences[VISITOR_ID]
    }

    override suspend fun saveVisitorId(visitorId: String) {
        dataStore.edit { preferences ->
            preferences[VISITOR_ID] = visitorId
        }
    }

    override suspend fun clearVisitorId() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }


    companion object {
        private val VISITOR_ID = stringPreferencesKey("visitor_id")
    }

}