package com.example.latihanuts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_berita2.*

class Berita2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita2)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Breaking News"

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        var brt = intent
        val berita = brt.getStringExtra("Berita")


        val tampil_nama = findViewById<TextView>(R.id.tx_berita)

        tampil_nama.text = berita

    }

    override  fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}