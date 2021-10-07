package com.example.tugasmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    //Menginisiasi Array yang berisi data Kota dan Nama
    val arrayKota = arrayOf("Banyuwangi", "Malang", "Jember", "Surabaya", "Jakarta")
    val arrayNama = arrayOf("Joko Widodo", "Bayu Firdaus", "Indra Wirawan", "Arip Suharsono", "Didi Betet")
    lateinit var arrGabungan : ArrayList<String>
    lateinit var adapterActv : ArrayAdapter<String>
    lateinit var adapterSpin : ArrayAdapter<String>
    lateinit var adapterLv : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Menginisiasi variable pada tiap Array
        arrGabungan = ArrayList()
        adapterActv = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayNama)
        adapterSpin = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayKota)
        adapterLv = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrGabungan)

        //Menginisiasi variable layout
        actv.setAdapter(adapterActv)
        sp1.adapter = adapterSpin
        lv1.adapter = adapterLv

        actv.threshold = 2
        actv.setOnItemClickListener { parent, view, position, id ->
            val isi = adapterActv.getItem(position)
            Toast.makeText(this, isi, Toast.LENGTH_SHORT).show()
        }

        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(baseContext, adapterSpin.getItem(position),Toast.LENGTH_SHORT).show()
            }
        }

        lv1.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, adapterLv.getItem(position), Toast.LENGTH_SHORT).show()
        }

        //Mengkonfigurasi button simpan
        btnSimpan.setOnClickListener {
            val var1 = actv.text
            val var2 = adapterSpin.getItem(sp1.selectedItemPosition)
            val var3 = "$var1 dari $var2"
            arrGabungan.add(var3)
            Toast.makeText(this, var3, Toast.LENGTH_SHORT).show()
            adapterLv.notifyDataSetChanged()
        }
    }
}