package com.lyhorng.moviex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lyhorng.moviex.databinding.ActivityLoginBinding
import com.lyhorng.moviex.ui.view.login.CreateNewAccount

class MainActivity : AppCompatActivity() {

    // Declare the binding object
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Set the root view using binding
        setContentView(binding.root)

        // Use binding to set the click listener for the TextView
        binding.tvSignUp.setOnClickListener {
            Log.e("Check SignIn", "Button clicked")
            val intent = Intent(this, CreateNewAccount::class.java)
            startActivity(intent)
        }
    }
}
