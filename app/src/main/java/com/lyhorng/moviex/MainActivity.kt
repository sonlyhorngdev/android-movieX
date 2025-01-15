package com.lyhorng.moviex

import com.lyhorng.moviex.base.BaseActivity
import com.lyhorng.moviex.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        super.setupUI()

    }

    override fun setupObservers() {
        super.setupObservers()
        // Add any observers if needed
    }
}
