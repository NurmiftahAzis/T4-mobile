package com.example.datamahasiswa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.datamahasiswa.utils.PrefManager
import com.example.datamahasiswa.utils.SettingsManager

class MainActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager
    private lateinit var rvMahasiswa: androidx.recyclerview.widget.RecyclerView
    private lateinit var fabAdd: com.google.android.material.floatingactionbutton.FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefManager = PrefManager(this)

        // 1. Inisialisasi View
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        rvMahasiswa = findViewById(R.id.rvMahasiswa)
        fabAdd = findViewById(R.id.fabAdd)

        // 2. Set Welcome Text
        tvWelcome.text = "Selamat datang, ${prefManager.getUsername()}!"

        // 3. Setup RecyclerView (Pastikan Anda sudah membuat Adapter)
        rvMahasiswa.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        // loadDataMahasiswa() // Panggil fungsi untuk mengambil data dari Room Database

        // 4. Tombol Logout
        btnLogout.setOnClickListener {
            prefManager.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // 5. Tombol Tambah (Ke Form Tambah/Edit)
        fabAdd.setOnClickListener {
            // Ganti AddMahasiswaActivity dengan nama activity form Anda
            val intent = Intent(this, MahasiswaDao::class.java)
            startActivity(intent)
        }

        // Perbaikan logika SettingsManager yang typo di kode awal Anda
        val settings = SettingsManager(this)
        if (settings.isDarkMode) {
            // Terapkan tema gelap jika aktif
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh data saat kembali ke activity ini
        // loadDataMahasiswa()
    }

//    private fun showDeleteDialog(mahasiswa: Mahasiswa) {
//        androidx.appcompat.app.AlertDialog.Builder(this)
//            .setTitle("Hapus Data?")
//            .setMessage("Hapus \"${mahasiswa.nama}\"? Tindakan ini tidak dapat dibatalkan.")
//            .setPositiveButton("Hapus") { _, _ ->
//                lifecycleScope.launch {
//                    database.mahasiswaDao().deleteMahasiswa(mahasiswa)
//                }
//            }
//            .setNegativeButton("Batal", null)
//            .show()
//    }
}