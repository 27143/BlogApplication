package com.example.blogapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {

    lateinit var imgeview:ImageView
    lateinit var signInBtn:Button
    lateinit var createAccountBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        imgeview = findViewById(R.id.girlImage)
        signInBtn= findViewById(R.id.btnSignIn)
        createAccountBtn = findViewById(R.id.btnCreateAccount)

        signInBtn.setOnClickListener(View.OnClickListener { view: View? ->

            val signintent = Intent(this,SignInActivity::class.java)
            startActivity(signintent)
        })

        createAccountBtn.setOnClickListener(View.OnClickListener {
            view: View? ->

            val intent = Intent(this,CreateAccountActivity::class.java)
            startActivity(intent)
        })




    }
}