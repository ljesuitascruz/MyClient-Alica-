package com.example.alecia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val second = findViewById<Button>(R.id.button )
        second.setOnClickListener {
            val intent=Intent ( this,MainFrame::class.java)
            startActivity(intent)
        }
    }
}