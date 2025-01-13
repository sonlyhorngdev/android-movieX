package com.lyhorng.moviex.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
        setupUI()
        setupObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    // Abstract method to initialize ViewBinding
    protected abstract fun getViewBinding(): VB

    // Optional setup methods for derived activities
    open fun setupUI() {}
    open fun setupObservers() {}

    // Common utility functions
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
