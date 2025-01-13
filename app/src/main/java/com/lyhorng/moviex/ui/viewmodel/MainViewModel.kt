package com.lyhorng.moviex.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.lyhorng.moviex.data.repository.UserRepository

class MainViewModel(private val userRepository: UserRepository) : ViewModel()  {
}