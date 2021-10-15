package com.example.tugasintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengaktifkan action click pada tiap button
        btn_explicit.setOnClickListener(this)
        btn_implicit.setOnClickListener(this)
        btn_send.setOnClickListener(this)
    }

    //Disini saya mengkonfigurasi tiap fungsi ketika button di klik, seperti explicit akan memunculkan text string
    //implicit memunculkan link github saya
    //send memunculkan teks yang saya input
    override fun onClick(v:View?) {
        when(v?.id){
            R.id.btn_explicit -> {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_implicit -> {
                val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/bayu-firdaus"))
                startActivity(implicitIntent)
            }
            R.id.btn_send -> {
                var message = et_message.text.toString()
                val intentWithMessage = Intent(this@MainActivity, SecondActivity::class.java)
                intentWithMessage.putExtra(SecondActivity.EXTRA_MESSAGE, message)
                startActivity(intentWithMessage)
            }
        }
    }
}