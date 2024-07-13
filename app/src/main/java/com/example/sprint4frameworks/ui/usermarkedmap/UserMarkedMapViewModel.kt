package com.example.sprint4frameworks.ui.usermarkedmap

import androidx.lifecycle.ViewModel
import com.example.sprint4frameworks.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserMarkedMapViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

}