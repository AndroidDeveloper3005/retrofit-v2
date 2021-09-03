package com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import com.himel.androiddeveloper3005.git.retrofit_v2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse1 : MutableLiveData<Response<Post>> = MutableLiveData()
    val customResponse : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val customResponse1 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post){
        viewModelScope.launch {
            val response:Response<Post> = repository.pushPosts(post)
            myResponse.value = response
        }

    }

    fun pushPost_1(userID : Int,id : Int, title : String , body : String){
        viewModelScope.launch {
            val response:Response<Post> = repository.pushPosts_1(userID,id,title ,body)
            myResponse.value = response
        }

    }


}