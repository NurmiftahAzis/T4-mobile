package com.example.datamahasiswa

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase

@Database(entities = [Mahasiswa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mahasiswa_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}