package com.example.datamahasiswa

import androidx.room3.*

@Dao
interface MahasiswaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)

    @Delete
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): androidx.lifecycle.LiveData<List<Mahasiswa>>
}