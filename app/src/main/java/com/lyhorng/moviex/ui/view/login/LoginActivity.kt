package com.lyhorng.moviex.ui.view.login

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.core.content.ContextCompat
import com.lyhorng.moviex.MainActivity
import com.lyhorng.moviex.R
import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private var email: String = ""
    private var password: String = ""

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set up click listeners
        binding.tvSignIn.setOnClickListener {
            loginValidation()
        }
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, CreateNewAccount::class.java)
            startActivity(intent)
        }
        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, CreateNewAccount::class.java)
            startActivity(intent)
        }
        binding.eyeIcon.setOnClickListener {
            val isPasswordVisible = binding.password.transformationMethod !is PasswordTransformationMethod
            showHidePassword(!isPasswordVisible)
        }
    }

    private  fun loginValidation() {
        email = binding.email.text.toString().trim()
        password = binding.password.text.toString().trim()

        Log.d("Check input email", email)
        Log.d("Check input password", password)

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Please enter email and password")
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showHidePassword(isChecked: Boolean) {
        if (isChecked) {
            binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.eyeIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_eye_open))
        } else {
            binding.password.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eyeIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_eye_closed))
        }
        binding.password.setSelection(binding.password.text.length)
    }
}
