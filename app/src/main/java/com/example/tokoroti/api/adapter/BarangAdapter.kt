package com.example.tokoroti.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoroti.R
import com.example.tokoroti.api.model.Barang

class BarangAdapter(private val dataSet: List<Barang>) : RecyclerView.Adapter<BarangAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Id: TextView
        val Nama: TextView
        val Kategori: TextView
        val Harga: TextView
        val Detail: ImageButton

        init {
            Id = view.findViewById(R.id.tv_id)
            Nama = view.findViewById(R.id.tv_nama)
            Kategori = view.findViewById(R.id.tv_kategori)
            Harga = view.findViewById(R.id.tv_harga)
            Detail = view.findViewById(R.id.btn_detail)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.Id.text = dataSet.get(position).id.toString()
        viewHolder.Nama.text = dataSet.get(position).nama
        viewHolder.Kategori.text = dataSet.get(position).kategori

        val data = dataSet.get(position)
        viewHolder.Detail.setOnClickListener{
            onItemClickCallback.onItemClicked(data)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Barang)
    }

    override fun getItemCount() = dataSet.size

}