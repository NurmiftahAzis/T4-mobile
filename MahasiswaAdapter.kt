package com.example.datamahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(
    private var list: List<Mahasiswa>,
    private val onEdit: (Mahasiswa) -> Unit,
    private val onDelete: (Mahasiswa) -> Unit
) : RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.etNama)
        val tvNim: TextView = view.findViewById(R.id.etNim)
        val tvProdi: TextView = view.findViewById(R.id.etProdi)
        val tvEmail: TextView = view.findViewById(R.id.etEmail)
        val tvSemester: TextView = view.findViewById(R.id.etSemester)
        val btnSimpan: TextView = view.findViewById(R.id.btnSimpan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mhs = list[position]
        holder.tvNama.text = mhs.nama
        holder.tvNim.text = mhs.nim

        holder.btnSimpan.setOnClickListener { onSimpan(mhs) }
    }

    private fun onSimpan(mhs: com.example.datamahasiswa.Mahasiswa) {}

    override fun getItemCount() = list.size

    fun updateData(newList: List<Mahasiswa>) {
        list = newList
        notifyDataSetChanged()
    }
}