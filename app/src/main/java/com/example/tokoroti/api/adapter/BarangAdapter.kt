package com.example.tokoroti.api.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoroti.DetailActivity
import com.example.tokoroti.InsertActivity
import com.example.tokoroti.R
import com.example.tokoroti.api.model.Barang
import com.example.tokoroti.api.model.BarangDataResponse

internal class BarangAdapter(private var BarangList: List<Barang>) : RecyclerView.Adapter<BarangAdapter.MyViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var Id: TextView = view.findViewById(R.id.tv_id)
        var Nama: TextView = view.findViewById(R.id.tv_nama)
        var Kategori: TextView = view.findViewById(R.id.tv_kategori)
        var Harga: TextView = view.findViewById(R.id.tv_harga)
//        var Deskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        var Detail: ImageButton = view.findViewById(R.id.btn_detail)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Barang = BarangList[position]

        holder.Id.text = Barang.id.toString()
        holder.Nama.text = Barang.nama
        holder.Kategori.text = Barang.kategori
        holder.Harga.text = Barang.harga.toString()
//        holder.Deskripsi.text = Barang.deskripsi.toString()

        val data = BarangList.get(position)
        holder.Detail.setOnClickListener{
            onItemClickCallback.onItemClicked(data)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Barang)
    }

    override fun getItemCount(): Int {
        return BarangList.size
    }

}
