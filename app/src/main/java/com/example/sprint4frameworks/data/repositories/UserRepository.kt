package com.example.sprint4frameworks.data.repositories

import com.example.sprint4frameworks.data.db.dao.UserDAO
import com.example.sprint4frameworks.data.db.entities.UserEntity
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class UserRepository @Inject constructor(private val userDao: UserDAO) {

    suspend fun getAllUsersFromDatabase(): List<UserEntity>? {
        return userDao.getAllUsers()
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getUser(id: Int): UserEntity? {
        return userDao.getUserById(id)
    }


    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}