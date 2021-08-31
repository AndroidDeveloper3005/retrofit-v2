package com.himel.androiddeveloper3005.git.retrofit_v2.repository

import com.himel.androiddeveloper3005.git.retrofit_v2.api.RetrofitInstance
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    //for dynamic end point
    //path annotation
    suspend fun  getPost1(number: Int) : Response<Post>{
        return RetrofitInstance.api.getPost1(number)
    }

    //query annotation
    suspend fun getCustomPosts(userId: Int,sort : String , order: String) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    //query map annotation
    suspend fun getCustomPosts1(userId: Int , options : Map<String,String>) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPosts1(userId,options)

    }
}