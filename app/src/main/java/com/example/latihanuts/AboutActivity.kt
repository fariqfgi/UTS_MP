package com.example.latihanuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Profile"

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        var aku = intent
        val nama = aku.getStringExtra("Namaku")
        val email = aku.getStringExtra("Email")
        val phone = aku.getStringExtra("Phone")

        val tampil_nama = findViewById<TextView>(R.id.tv_namaku)
        val tampil_email = findViewById<TextView>(R.id.tv_email)
        val tampil_phone = findViewById<TextView>(R.id.tv_phone)

        tampil_nama.text = nama
        tampil_email.text = email
        tampil_phone.text = phone

        img_tv.setOnClickListener {
            Toast.makeText(this, "Keren", Toast.LENGTH_SHORT).show()
        }
    }

    override  fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
