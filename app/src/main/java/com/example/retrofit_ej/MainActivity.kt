package com.example.retrofit_ej

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import data.RetrofitService
import data.RetrofitServiceFactory
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            try {
                val movies = service.listPopularMovies("d30e1f350220f9aad6c4110df385d380", "US")
                println(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        setContentView(R.layout.activity_main)
    }
}