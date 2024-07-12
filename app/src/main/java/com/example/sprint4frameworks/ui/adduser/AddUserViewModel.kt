package com.example.sprint4frameworks.ui.adduser

import androidx.lifecycle.ViewModel
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.data.repositories.CitiesRepository
import com.example.sprint4frameworks.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val userRepository: UserRepository,
) :
    ViewModel() {
    suspend fun addUser(user: UserEntity) = userRepository.insertUser(user)
    fun getCities() = CitiesRepository().getCities()
}