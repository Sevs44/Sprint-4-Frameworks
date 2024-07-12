package com.example.sprint4frameworks.ui.userlist


import androidx.lifecycle.ViewModel
import com.example.sprint4frameworks.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    suspend fun getUsers() = userRepository.getAllUsersFromDatabase()

}
