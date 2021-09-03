package com.himel.androiddeveloper3005.git.retrofit_v2.api

import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import retrofit2.Response
import retrofit2.http.*

interface Api {
    //post request
    @POST("posts")
    suspend fun pushPost(
            @Body post: Post
    ) : Response<Post>

    //post request
    @FormUrlEncoded //jodi ai annotation na ullekh kori thahole data JSON format
    // e server e jay!!! ar annotation dele data key and velue te alada take
    @POST("posts")
    suspend fun pushPost_1(
            @Field("myUserID") myUserID : Int,
            @Field("id") id : Int,
            @Field("title") title : String,
            @Field("body") body : String

    ) : Response<Post>
}