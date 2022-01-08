package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    lateinit var Tambah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Tambah = findViewById(R.id.btn_tambah)

        Tambah.setOnClickListener {
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

//        TODO(Tampilin Data)

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
