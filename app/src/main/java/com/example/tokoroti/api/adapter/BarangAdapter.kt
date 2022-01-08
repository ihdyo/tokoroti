package com.example.tokoroti.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoroti.R
import com.example.tokoroti.api.model.BarangDataResponse

internal class BarangAdapter(private var barangList: List<BarangDataResponse>) :
    RecyclerView.Adapter<BarangAdapter.MyViewHolder>() {
        internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
            var id: TextView = view.findViewById(R.id.tv_id)
            var nama: TextView = view.findViewById(R.id.tv_nama)
            var harga: TextView = view.findViewById(R.id.tv_harga)
        }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val barang = barangList[position]
        holder.id.text = barang.id.toString()
        holder.nama.text = barang.nama
        holder.harga.text = barang.harga.toString()
    }

    override fun getItemCount(): Int {
        return barangList.size
    }
}