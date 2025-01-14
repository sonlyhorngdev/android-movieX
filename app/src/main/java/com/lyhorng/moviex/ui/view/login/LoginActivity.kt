package com.lyhorng.moviex.ui.view.login

import android.content.Intent
import android.os.Bundle
import com.lyhorng.moviex.MainActivity
import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {


    override fun getViewBinding(): ActivityLoginBinding {
        // Inflate the layout and return the binding
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the root view using binding
        setContentView(binding.root)

        // Set up click listeners
        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, CreateNewAccount::class.java)
            startActivity(intent)
        }
        binding.tvForgotPassword.setOnClickListener {
            // Navigate to a "Forgot Password" activity
            val intent = Intent(this, CreateNewAccount::class.java)
            startActivity(intent)
        }
    }
}
