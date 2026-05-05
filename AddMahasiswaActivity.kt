package com.example.datamahasiswa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddMahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_mahasiswa) // Buat layout dengan EditText Nama, NIM, dll.

        val db = AppDatabase.getDatabase(this)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val nama = findViewById<EditText>(R.id.etNama).text.toString()
            val nim = findViewById<EditText>(R.id.etNim).text.toString()
            val prodi = findViewById<EditText>(R.id.etProdi).text.toString()
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val semester = findViewById<EditText>(R.id.etSemester).text.toString()

            val mhs = Mahasiswa(nama = nama, nim = nim, prodi = prodi, email = email, semester = semester)

            lifecycleScope.launch {
                db.mahasiswaDao().insertMahasiswa(mhs)
                finish() // Kembali ke MainActivity
            }
        }
    }
}