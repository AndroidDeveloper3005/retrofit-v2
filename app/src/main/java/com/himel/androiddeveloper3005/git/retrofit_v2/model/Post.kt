package com.himel.androiddeveloper3005.git.retrofit_v2.model

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName ("userId")//original name na dile ei vabe korte hobe
    val myUserID : Int,//modified name jar jonno upore mention korte hoiche
    val id : Int,
    val title : String,
    val body : String
        )