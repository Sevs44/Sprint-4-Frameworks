package com.example.sprint4frameworks.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sprint4frameworks.data.db.dao.UserDAO
import com.example.sprint4frameworks.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UsersDataBase : RoomDatabase() {

    abstract fun userDao(): UserDAO
}