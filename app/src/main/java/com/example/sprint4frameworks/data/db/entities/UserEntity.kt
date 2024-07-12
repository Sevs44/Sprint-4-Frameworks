package com.example.sprint4frameworks.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "favoriteColor") val favoriteColor: String,
    @ColumnInfo(name = "birthdate") val birthdate: String,
    @ColumnInfo(name = "favoriteCityCoordinatesLat") val favoriteCityCoordinatesLat: Double,
    @ColumnInfo(name = "favoriteCityCoordinatesLng") val favoriteCityCoordinatesLng: Double,
    @ColumnInfo(name = "favoriteCityName") val favoriteCityName: String,
    @ColumnInfo(name = "favoriteNumber") val favoriteNumber: Int,
    @ColumnInfo(name = "actualPositionLat") val actualPositionLat: Double,
    @ColumnInfo(name = "actualPositionLng") val actualPositionLng: Double
)