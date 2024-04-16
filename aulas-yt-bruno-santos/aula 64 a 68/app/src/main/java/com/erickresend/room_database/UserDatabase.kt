package com.erickresend.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private lateinit var INSTANCE: UserDatabase

        fun getInstance(context: Context): UserDatabase {
            if(!::INSTANCE.isInitialized) {
                synchronized(UserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "User")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}