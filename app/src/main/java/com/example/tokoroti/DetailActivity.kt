package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.adapter.BarangAdapter
import com.example.tokoroti.api.model.Barang
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    lateinit var Id: TextView
    lateinit var Title: TextView
    lateinit var Nama: TextView
    lateinit var Kategori: TextView
    lateinit var Deskripsi: TextView
    lateinit var Harga: TextView
    lateinit var Hapus: Button
    lateinit var Edit: Button
    lateinit var Kembali: Button

    fun onCreate(savedInstanceState: Bundle?, BarangList: List<Barang>, Position: Int) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Id = findViewById(R.id.tv_id)
        Title = findViewById(R.id.tv_title)
        Nama = findViewById(R.id.tv_nama)
        Kategori = findViewById(R.id.tv_kategori)
        Harga = findViewById(R.id.tv_harga)
//        Deskripsi = findViewById(R.id.tv_deskripsi)
        Edit = findViewById(R.id.btn_edit)
        Hapus = findViewById(R.id.btn_hapus)
        Kembali = findViewById(R.id.btn_kembali)

        Edit.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        Hapus.setOnClickListener {
            var id = Id.text.toString().toInt()

            val retro = ApiConfig().getRetroClientInstance().deleteBarang(id)
            retro.enqueue(object : Callback<BarangResponse> {
                override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                    if (response.isSuccessful){
                        val Barang = response.body()!!
                        if (Barang.code==200){
                            Id.setText("")
                        }
                        Toast.makeText(this@DetailActivity, Barang.message.toString() + " berhasil dihapus", Toast.LENGTH_SHORT).show();
                    }else{
                        Log.e("Error Code : ", response.code().toString())
                        Log.e("Error Message : ", response.message().toString())
                    }
                }
                override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                    Log.e("Failed", t.message.toString())
                }
            })
        }

        Kembali.setOnClickListener {
            finish()
        }

        val retro = ApiConfig().getRetroClientInstance().getBarang()
        retro.enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){

                    val Barang = BarangList[Position]

                    Id.text = Barang.id.toString()
                    Title.text = Barang.nama
                    Nama.text = Barang.nama
                    Kategori.text = Barang.kategori
                    Harga.text = Barang.harga.toString()
//                    Deskripsi.text = Barang.deskripsi

                }else{
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Message :", response.message().toString())
                }
            }
            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }
        })

    }

}
