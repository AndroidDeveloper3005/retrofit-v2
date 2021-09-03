package com.himel.androiddeveloper3005.git.retrofit_v2.repository

import com.himel.androiddeveloper3005.git.retrofit_v2.api.RetrofitInstance
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response

class Repository {
    suspend fun pushPosts(post: Post) : Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPosts_1(userID : Int,id : Int, title : String , body : String) : Response<Post>{
        return RetrofitInstance.api.pushPost_1(userID,id,title ,body )
    }

}