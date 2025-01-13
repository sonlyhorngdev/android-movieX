package com.lyhorng.moviex.util
//This is a wrapper class to represent success and error states for data loading.
sealed  class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val message: String, val data: T? = null) : Resource<T>()
    class Loading<T> : Resource<T>()
}