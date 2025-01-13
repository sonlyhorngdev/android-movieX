package com.lyhorng.moviex.ui.view.login

import android.os.Bundle
import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityCreateNewBinding

class CreateNewAccount: BaseActivity<ActivityCreateNewBinding>()  {
    override fun getViewBinding(): ActivityCreateNewBinding {
        return ActivityCreateNewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}