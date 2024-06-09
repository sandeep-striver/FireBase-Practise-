package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.FireBase.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@Suppress("MemberVisibilityCanBePrivate")
class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val etname = findViewById<EditText>(R.id.textusername)
        val etmail = findViewById<EditText>(R.id.textemail)
        val etpaswrd = findViewById<EditText>(R.id.textpassword)
        val etunqeid = findViewById<EditText>(R.id.textuniqueid)


        button.setOnClickListener{

            val name = etname.text.toString()
            val mail = etmail.text.toString()
            val password = etpaswrd.text.toString()
            val uniqueId = etunqeid.text.toString()

            val user= user(name,mail,password,uniqueId)
            database = FirebaseDatabase.getInstance().getReference("user")
            database.child(uniqueId).setValue(user).addOnSuccessListener {


                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
            }

        }
    }
