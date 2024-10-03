package com.example.datastorepractice
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PetManager (private val dataStore : DataStore<Preferences>) {
    companion object {
        val PET_AGE_KEY = intPreferencesKey("PET_AGE_KEY")
        val PET_NAME_KEY = stringPreferencesKey("PET_NAME_KEY")
        val PET_GENDER_KEY = booleanPreferencesKey("PET_GENDER_KEY")
        val PET_BIRTH_KEY = stringPreferencesKey("PET_BIRTH_KEY")
    }

    suspend fun storePetInfo(
        age : Int,
        name : String,
        isMale : Boolean,
        birth : String
    ) {
        dataStore.edit { pet ->
            pet[PET_AGE_KEY] = age
            pet[PET_NAME_KEY] = name
            pet[PET_GENDER_KEY] = isMale
            pet[PET_BIRTH_KEY] = birth
        }
    }

    val petAgeFlow : Flow<Int?> = dataStore.data.map {
        it[PET_AGE_KEY]
    }

    val petNameFlow : Flow<String?> = dataStore.data.map {
        it[PET_NAME_KEY]
    }

    val petGenderFlow : Flow<Boolean?> = dataStore.data.map {
        it[PET_GENDER_KEY]
    }

    val petBirthFlow : Flow<String?> = dataStore.data.map {
        it[PET_BIRTH_KEY]
    }
}