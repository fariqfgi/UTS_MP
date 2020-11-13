package com.example.latihanuts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences("SHARED PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemembered) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        login.setOnClickListener {
            val mail: String = email.text.toString()
            val pass: String = password.text.toString()
            val checked: Boolean = checkBox.isChecked

            when{
                mail == "" -> {
                    val msg = Toast.makeText(applicationContext, "Masukkan Email", Toast.LENGTH_LONG)
                    msg.setGravity(Gravity.TOP, 0, 140)
                    msg.show()
                }
                pass == "" -> {
                    val msg = Toast.makeText(applicationContext, "Masukkan Password", Toast.LENGTH_LONG)
                    msg.setGravity(Gravity.TOP, 0, 140)
                    msg.show()
                }
                else -> {
                    val msg = Toast.makeText(applicationContext, "Berhasil Login", Toast.LENGTH_LONG)
                    msg.setGravity(Gravity.TOP, 0, 140)
                    msg.show()
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("MAIL", mail)
                    editor.putString("PASS", pass)
                    editor.putBoolean("CHECKBOX", checked)
                    editor.apply()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        }



    }
}