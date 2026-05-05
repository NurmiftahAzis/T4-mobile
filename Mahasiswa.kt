package com.example.datamahasiswa

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "siswa")
data class Mahasiswa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val nim: String,
    val prodi: String,
    val email: String,
    val semester: String
)