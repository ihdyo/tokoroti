package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.adapter.BarangAdapter
import com.example.tokoroti.api.model.Barang
import com.example.tokoroti.api.model.BarangDataResponse
import com.example.tokoroti.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private var adapter: BarangAdapter? = null

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Tambah = findViewById<Button>(R.id.btn_tambah)
        Tambah.setOnClickListener {
            Intent(this@MenuActivity, InsertActivity::class.java)
        }

        READ()

    }

    fun READ() {
        adapter = null
        binding.rvMenu.adapter = null
        binding.rvMenu.layoutManager = null
        val client = ApiConfig().getRetroClientInstance().getBarang()
        client.enqueue(object : Callback<BarangDataResponse> {
            override fun onResponse(
                call: Call<BarangDataResponse>,
                response: Response<BarangDataResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        if (responseBody.data != null){
                            binding.rvMenu.layoutManager = LinearLayoutManager(this@MenuActivity)
                            adapter = BarangAdapter(responseBody.data)
                            binding.rvMenu.adapter = adapter

                            adapter?.setOnItemClickCallback(object : BarangAdapter.OnItemClickCallback{
                                override fun onItemClicked(data: Barang) {
                                    Intent(this@MenuActivity, DetailActivity::class.java)
                                        .putExtra("Id", data.id)
                                        .putExtra("Nama", data.nama)
                                        .putExtra("Kategori", data.kategori)
                                        .putExtra("Harga", data.harga)
                                }
                            })
                        }
                    }
                }
            }
            override fun onFailure(call: retrofit2.Call<BarangDataResponse>, t: Throwable) {
            }
        })
    }


//    fun READ(view: View) {
//        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
//        retro.getBarang().enqueue(object : Callback<BarangResponse> {
//            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
//                if (response.isSuccessful){
//                    val Barang = response.body()!!
//                    Menu = view.findViewById(R.id.rv_menu)
//                    Menu.setHasFixedSize(true)
//                    Menu.layoutManager = LinearLayoutManager(activity)
//                    val BarangAdapter = BarangAdapter(Barang.data)
//                    Menu.adapter = BarangAdapter
//                    BarangAdapter.notifyDataSetChanged()
//                }else{
//                    Log.e("Error Code : ", response.code().toString())
//                    Log.e("Error Message :", response.message().toString())
//                }
//            }
//            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
//                Log.e("Failed", t.message.toString())
//            }
//        })
//    }


}