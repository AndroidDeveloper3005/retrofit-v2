package com.himel.androiddeveloper3005.git.retrofit_v2.api

import com.himel.androiddeveloper3005.git.retrofit_v2.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api : Api by lazy{
        retrofit.create(Api::class.java)

    }
}