package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.adapter.BarangAdapter
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {

    lateinit var Menu: RecyclerView
    lateinit var Tambah: Button
    private lateinit var Adapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Adapter = BarangAdapter(arrayListOf())
        Menu = findViewById(R.id.rv_menu)
        Menu = findViewById(R.id.rv_menu)
        Tambah = findViewById(R.id.btn_tambah)

        Tambah.setOnClickListener {
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

        Menu.setHasFixedSize(true)
        Menu.layoutManager = LinearLayoutManager(this@MenuActivity, LinearLayoutManager.VERTICAL ,false)
        Menu.adapter = Adapter

        val retro = ApiConfig().getRetroClientInstance().getBarang()
        retro.enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    val Adapter = BarangAdapter(Barang.data)
                    Menu.adapter = Adapter
                    Adapter.notifyDataSetChanged()

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


//val NIM = intent.getStringExtra("EXTRA_NIM")
//val nim = findViewById<TextView>(R.id.nim)
//nim.text = NIM
