package com.example.sprint4frameworks.ui.userdetails

import androidx.lifecycle.ViewModel
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    suspend fun getUser(id: Int): UserEntity? {
        return userRepository.getUser(id)
    }

}