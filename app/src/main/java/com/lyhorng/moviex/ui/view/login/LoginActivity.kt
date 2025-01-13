package com.lyhorng.moviex.ui.view.login

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.lyhorng.moviex.R
import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityLoginBinding
import com.lyhorng.moviex.ui.viewmodel.LoginViewModel
import com.lyhorng.moviex.util.Resource

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}
