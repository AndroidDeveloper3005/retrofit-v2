package com.himel.androiddeveloper3005.git.retrofit_v2.api

import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @GET("posts/1")  //"posts/1" is end point of link
    suspend fun getPost() : Response<Post>

    //get end point dynamically
    //path anotation

    @GET("posts/{postNumber}")
    suspend fun getPost1(
            @Path("postNumber") number: Int
    ) : Response<Post>

    //Query annotation
    //multiple query annotation
    @GET("posts")
    suspend fun getCustomPost(
            @Query("userId") userId : Int,
            @Query("_sort") sort : String,
            @Query("_order") order : String

    ) : Response<List<Post>>

    //Query map
    @GET("posts")
    suspend fun getCustomPosts1(
            @Query("userId") userId : Int,
            @QueryMap options: Map<String,String>

            ): Response<List<Post>>
}