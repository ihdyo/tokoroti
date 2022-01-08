package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.http.DELETE

class DetailActivity : AppCompatActivity() {

    lateinit var Title: TextView
    lateinit var Nama: TextView
    lateinit var Kategori: TextView
    lateinit var Deskripsi: TextView
    lateinit var Harga: TextView
    lateinit var Hapus: Button
    lateinit var Edit: Button
    lateinit var Kembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Title = findViewById(R.id.tv_title)
        Nama = findViewById(R.id.tv_nama)
        Kategori = findViewById(R.id.tv_kategori)
        Harga = findViewById(R.id.tv_harga)
        Deskripsi = findViewById(R.id.tv_deskripsi)
        Edit = findViewById(R.id.btn_edit)
        Hapus = findViewById(R.id.btn_hapus)
        Kembali = findViewById(R.id.btn_kembali)

        Edit.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        Hapus.setOnClickListener {
//            TODO(Masukin logika DELETE)
//            TODO(Tampilkan TOAST)
//            TODO(Buka FRAGMENT Konfirmasi)
        }

        Kembali.setOnClickListener {
            finish()
        }

    }


//    fun DELETE(){
//
//        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
//        retro.deleteBarang(Id.text.toString().toInt()).enqueue(object : Callback<BarangResponse> {
//            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
//                if (response.isSuccessful){
//                    val Barang = response.body()!!
//                    if (Barang.code==200){
//                        Id.setText("")
//                    }
//                    Toast.makeText(view!!.context, "Delete Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Log.e("Error Code : ", response.code().toString())
//                    Log.e("Error Message : ", response.message().toString())
//                }
//            }
//            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
//                Log.e("Failed", t.message.toString())
//            }
//        })
//    }


}
