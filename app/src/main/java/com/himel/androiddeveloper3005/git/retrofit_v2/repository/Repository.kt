package com.himel.androiddeveloper3005.git.retrofit_v2.repository

import com.himel.androiddeveloper3005.git.retrofit_v2.api.RetrofitInstance
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    //for dynamic end point
    suspend fun  getPost1(number: Int) : Response<Post>{
        return RetrofitInstance.api.getPost1(number)
    }
}