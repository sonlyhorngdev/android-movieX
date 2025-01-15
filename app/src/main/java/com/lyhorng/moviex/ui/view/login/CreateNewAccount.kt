package com.lyhorng.moviex.ui.view.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.core.content.ContextCompat
import com.lyhorng.moviex.R
import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityCreateNewBinding

class CreateNewAccount: BaseActivity<ActivityCreateNewBinding>()  {

    private var name: String = ""
    private var email: String = ""
    private var password: String = ""
    private var isAgreeChecked: Boolean = false

    override fun getViewBinding(): ActivityCreateNewBinding {
        return ActivityCreateNewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvSignUp.setOnClickListener{}
        binding.tvSignIn.setOnClickListener{}
        binding.eyeIcon.setOnClickListener {
            val isPasswordVisible = binding.password.transformationMethod !is PasswordTransformationMethod
            showHidePassword(!isPasswordVisible)
        }

        binding.ivAgree.setOnClickListener {
            isAgreeChecked = !isAgreeChecked
            agreeCheck(isAgreeChecked)
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

    private fun agreeCheck(isAgree: Boolean) {
        if(isAgree) {
            binding.ivAgree.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_checked))
        } else {
            binding.ivAgree.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_check))
        }
    }
}