package com.himel.androiddeveloper3005.git.retrofit_v2.api

import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("posts/1")  //"posts/1" is end point of link
    suspend fun getPost() : Response<Post>

    //get end point dynamically
    //path anotation

    @GET("posts/{postNumber}")
    suspend fun getPost1(
            @Path("postNumber") number: Int
    ) : Response<Post>

    //Queary annotation
    @GET("posts")
    suspend fun getCustomPost(
            @Query("userId") userId : Int
    ) : Response<List<Post>>
}