package com.example.alecia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_main_frame.btn_delete
import kotlinx.android.synthetic.main.activity_main_frame.btn_insert
import kotlinx.android.synthetic.main.activity_main_frame.btn_read
//import kotlinx.android.synthetic.main.activity_main_frame.btn_update
import kotlinx.android.synthetic.main.activity_main_frame.etvAge
import kotlinx.android.synthetic.main.activity_main_frame.etvName
import kotlinx.android.synthetic.main.activity_main_frame.tvResult

class MainFrame : AppCompatActivity()

      {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frame)

        val second = findViewById<Button>(R.id.btn1)
        second.setOnClickListener {
            val intent=Intent ( this,MainActivity2::class.java)
            startActivity(intent)
        }

        val second1 = findViewById<Button>(R.id.btn2)
        second1.setOnClickListener {
            val intent=Intent ( this,MainActivity::class.java)
            startActivity(intent)
        }

        val context = this
        var db = DataBaseHandler(context)
        btn_insert.setOnClickListener({
            if (etvName.text.toString().length > 0 &&
                etvAge.text.toString().length > 0) {
                var user = User(etvName.text.toString(),etvAge.text.toString())
                db.insertData(user)
            } else {
                Toast.makeText(context,"Please Fill All Data's",Toast.LENGTH_SHORT).show()
            }
        })

        btn_read.setOnClickListener({
            var data = db.readData()
            tvResult.text = ""
            for (i in 0..(data.size - 1)) {
                tvResult.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).age + "\n")
            }
        })


       // btn_delete.setOnClickListener({
        //    db.deleteData()
          //  btn_read.performClick()
    //    })

    }

      }