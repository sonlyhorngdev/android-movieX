package com.lyhorng.moviex.ui.view.login

import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}
