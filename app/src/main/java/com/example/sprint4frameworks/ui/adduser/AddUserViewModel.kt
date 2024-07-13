package com.example.sprint4frameworks.ui.adduser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.data.repositories.CitiesRepository
import com.example.sprint4frameworks.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    fun getCities() = CitiesRepository().getCities()

    fun addUser(
        name: String,
        favColor: String,
        birthdate: String,
        favCityLat: Double,
        favCityLng: Double,
        favCityName: String,
        favNumber: Int,
        actualLocationLat: Double,
        actualLocationLng: Double
    ) {
        viewModelScope.launch {
            val user = UserEntity(
                0,
                name,
                favColor,
                birthdate,
                favCityLat,
                favCityLng,
                favCityName,
                favNumber,
                actualLocationLat,
                actualLocationLng
            )
            userRepository.insertUser(user)
        }
    }

    fun checkFields(
        name: String,
        favColor: String,
        birthdate: String,
        favCityLat: Double,
        favCityLng: Double,
        favCityName: String,
        favNumber: String,
        actualLocationLat: Double,
        actualLocationLng: Double
    ): Boolean {
        return (name == null ||
                favColor == null ||
                birthdate == null ||
                favCityLat == null ||
                favCityLng == null ||
                favCityName == null ||
                favNumber == null ||
                actualLocationLat == null ||
                actualLocationLng == null)
    }
}