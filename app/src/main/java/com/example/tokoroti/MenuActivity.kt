package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.adapter.BarangAdapter
import com.example.tokoroti.api.model.Barang
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {

    lateinit var Menu: RecyclerView
    lateinit var Tambah: Button
    lateinit var Swipe: SwipeRefreshLayout
    private lateinit var Adapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Menu = findViewById(R.id.rv_menu)
        Tambah = findViewById(R.id.btn_tambah)
        Swipe = findViewById(R.id.swipe)

        Tambah.setOnClickListener {
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

        Swipe.setOnRefreshListener {
            READ()
            if(Swipe.isRefreshing()){
                Swipe.setRefreshing(false)
            }
        }

        getRecyclerView()
        READ()

    }

    private fun getRecyclerView() {
        Adapter = BarangAdapter(arrayListOf())
        Menu.setHasFixedSize(true)
        Menu.layoutManager = LinearLayoutManager(this@MenuActivity, LinearLayoutManager.VERTICAL ,false)
        Menu.adapter = Adapter
    }

    private fun READ() {
        val retro = ApiConfig().getRetroClientInstance().getBarang()
        retro.enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    val Adapter = BarangAdapter(Barang.data)
                    Menu.adapter = Adapter
                    Adapter.notifyDataSetChanged()

                    Adapter?.setOnItemClickCallback(object : BarangAdapter.OnItemClickCallback {
                        override fun onItemClicked(data: Barang) {
                            startActivity(
                                Intent(this@MenuActivity, DetailActivity::class.java)
                                    .putExtra("ID", data.id.toString())
                                    .putExtra("NAMA", data.nama)
                                    .putExtra("KATEGORI", data.kategori)
                                    .putExtra("HARGA", data.harga)
//                                    .putExtra("DESKRIPSI", data.deskripsi)
                            )
                        }
                    })
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
