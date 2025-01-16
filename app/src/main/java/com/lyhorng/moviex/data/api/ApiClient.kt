package com.lyhorng.moviex.data.api

import com.lyhorng.moviex.utils.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest: Request = chain.request()

            // Add the API key to the request headers
            val newRequest = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer ${ApiConstants.API_KEY}") // Add the API key to headers
                .build()

            chain.proceed(newRequest)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL) // Use the constant base URL
        .client(client)  // Attach custom OkHttp client with interceptor
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}