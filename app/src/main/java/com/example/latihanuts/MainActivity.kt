package com.example.latihanuts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var prefences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefences = getSharedPreferences("SHARED PREF", Context.MODE_PRIVATE)

        val mail = prefences.getString("MAIL", "")
        mailTV.text = mail

        btn_cal.setOnClickListener {
            val intent = Intent(this, CalActivity::class.java)
            startActivity(intent)
        }


        btn_about.setOnClickListener {
            val namaku = "Fariq"
            val email = "fariqfgi@techpoci.com"
            val phone = "08080808080"

            val about = Intent(this, AboutActivity::class.java)
            about.putExtra("Namaku", namaku)
            about.putExtra("Email", email)
            about.putExtra("Phone", phone)
            startActivity(about)
        }

        btn_form.setOnClickListener {
            val intent = Intent(this, BeritaActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            val editor: SharedPreferences.Editor = prefences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
