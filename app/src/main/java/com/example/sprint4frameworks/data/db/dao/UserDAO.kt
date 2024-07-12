package com.example.sprint4frameworks.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sprint4frameworks.data.db.entities.UserEntity

@Dao
interface UserDAO {
    @Query("SELECT * FROM users ORDER BY name DESC")
    fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserEntity?

    @Delete
    suspend fun deleteUser(user: UserEntity)
}