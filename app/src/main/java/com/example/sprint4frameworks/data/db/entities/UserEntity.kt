package com.example.sprint4frameworks.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val favoriteColor: String,
    val birthdate: String,
    val favoriteCityCoordinates: LatLng,
    val favoriteCityName: String,
    val favoriteNumber: Int,
    val actualPosition: LatLng
)