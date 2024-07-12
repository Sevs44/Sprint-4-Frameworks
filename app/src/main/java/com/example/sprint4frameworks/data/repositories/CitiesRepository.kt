package com.example.sprint4frameworks.data.repositories

import com.example.sprint4frameworks.data.models.City

class CitiesRepository {
    private val cityList = listOf(
        City("New York", 40.7128, -74.0060),
        City("Los Angeles", 34.0522, -118.2437),
        City("Chicago", 41.8781, -87.6298),
        City("Houston", 29.7604, -95.3698),
        City("Miami", 25.7617, -80.1918)
    )

    fun getCities() = cityList
}